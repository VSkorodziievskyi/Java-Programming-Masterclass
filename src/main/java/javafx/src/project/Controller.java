package project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class Controller {
    @FXML
    public BorderPane mainBorderPane;

    @FXML
    private TableView<Contact> tableView;

    @FXML
    private ContextMenu tableContextMenu;


    public void initialize() {
        tableContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteContact();
            }
        });

        tableContextMenu = new ContextMenu();
        MenuItem editMenuItem = new MenuItem("Edit");
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showEditContactDialog();
            }
        });

        tableContextMenu.getItems().addAll(deleteMenuItem);
        tableContextMenu.getItems().addAll(editMenuItem);

        tableView.setRowFactory(new Callback<TableView<Contact>, TableRow<Contact>>() {
            @Override
            public TableRow<Contact> call(TableView<Contact> param) {
                TableRow<Contact> row = new TableRow<>();

                row.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                row.setContextMenu(null);
                            } else {
                                row.setContextMenu(tableContextMenu);
                            }
                        });
                return row;
            }
        });

        tableView.setItems(ContactData.getInstance().getContacts());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().selectFirst();

    }

    public void showAddContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add Contact");
        dialog.setHeaderText("Use this dialog to add a new contact.");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            if (verifyContactData(controller, false)) {
                Contact newContact = controller.processAddContact();
                tableView.getSelectionModel().select(newContact);
            }
        }
    }


    public void showEditContactDialog() {
        Contact oldContact = tableView.getSelectionModel().getSelectedItem();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Use this dialog to edit a current contact.");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
            DialogController dialogController = fxmlLoader.getController();
            dialogController.getFirstName().setText(oldContact.getFirstName());
            dialogController.getLastNumber().setText(oldContact.getLastName());
            dialogController.getPhoneNumber().setText(oldContact.getPhoneNumber());
            dialogController.getNotes().setText(oldContact.getNotes());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        } catch (NullPointerException e) {
            alertEmptyList();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            if (verifyContactData(controller, true)) {
                Contact newContact = controller.processEditContact(oldContact);
                tableView.getSelectionModel().select(newContact);
            }

        }
    }

    private boolean verifyContactData(DialogController controller, boolean edit) {
        boolean correct = controller.verify();
        if (!correct) {
            alertContactError();
            if (edit) {
                showEditContactDialog();
            } else {
                showAddContactDialog();
            }
            return false;
        }
        return true;
    }

    public void deleteContact() {
        try {
            Contact contact = tableView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Contact");
            alert.setHeaderText("Do you want to delete the following contact? \n\"" + contact.getFirstName().trim() + " " + contact.getLastName().trim() + "\"");
            alert.setContentText("Press OK to confirm, or Cancel to back out.");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                ContactData.getInstance().deleteContact(contact);
            }
        } catch (NullPointerException e) {
            alertEmptyList();
        }
    }

    public void deleteClickerHandler(KeyEvent keyEvent) {
        Contact item = tableView.getSelectionModel().getSelectedItem();
        if (item != null && keyEvent.getCode() == KeyCode.DELETE) {
            deleteContact();
        }
    }

    private void alertContactError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.getDialogPane().setMinWidth(400);
        alert.setTitle("Error");
        alert.setHeaderText("Error while processing new contact data!\n" +
                "Make sure you wrote contact data correctly.");
        alert.setContentText("✔ First name field should contain 2-16 letters in upper or lower case. \n" +
                "✔ Last name field should contain 2-24 letters in upper or lower case. \n" +
                "✔ Phone number should be formatted as: \n" +
                "     1234567890 or 123-456-7890 or (123)456-7890 or (123)4567890 \n" +
                "✔ Notes field should contain 3-50 symbols.");
        alert.showAndWait();
    }

    private void alertEmptyList() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.getDialogPane().setMinWidth(400);
        alert.setTitle("Error");
        alert.setHeaderText("Error while processing contact data!\n" +
                "Make sure the contact list is not empty.");
        alert.setContentText("You need to have a contact to process its data.");
        alert.showAndWait();
    }

    public void informContactRules() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinWidth(400);
        alert.setTitle("How to add a contact?");
        alert.setHeaderText("Use this instruction to add contact data properly.");
        alert.setContentText("✔ First name field should contain 2-16 letters in upper or lower case. \n" +
                "✔ Last name field should contain 2-24 letters in upper or lower case. \n" +
                "✔ Phone number should be formatted as: \n" +
                "     1234567890 or 123-456-7890 or (123)456-7890 or (123)4567890 \n" +
                "✔ Notes field should contain 3-50 symbols.\n" +
                "✔ Example:  Nicole  Cain  1234567890  N/A");
        alert.showAndWait();
    }

    public void about() {
        Alert alert = new Alert(
                Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Thank you for testing this simple program :)");
        FlowPane flow = new FlowPane();
        Label label = new Label("If existing functions of this program have any bugs, please contact me or leave a comment under this program commit.\n" +
                "I am open to new ideas, alternative viewpoints, and creative contacts." +
                " So you can also add me as a friend on LinkedIn, I would appreciate it. ");
        Hyperlink link = new Hyperlink("LinkedIn link");
        flow.getChildren().addAll(label, link);

        link.setOnAction((evt) -> {
            alert.close();
            try {
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/vskorodziievskyi/"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        alert.getDialogPane().contentProperty().set(flow);
        alert.showAndWait();
    }

    public void quit() {
        Platform.exit();
    }
}

