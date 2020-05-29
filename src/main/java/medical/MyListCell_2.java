package medical;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;

class MyListCell_2 extends ListCell<Medicament> {
    @Override
    protected void updateItem(Medicament item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)

            setGraphic(null);
        else {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("midicament.fxml"));

            loader.setControllerFactory(c -> {
                return new MedicamentController(item);
            });
            HBox Box =new HBox();
            Button btn = new Button();
            btn.getStylesheets().add("Css/button1.css");
            Button btn1 = new Button();
            btn1.getStylesheets().add("Css/button1.css");

            btn.setOnAction(e->getListView().getItems().remove(item));


            Image image = new Image("medical/img/delete.png", 35, 35, false, false);
            btn.setGraphic(new ImageView(image));
            Image image1 = new Image("medical/img/plss.png", 35, 35, false, false);
            btn1.setGraphic(new ImageView(image1));



            try {
                Box.getChildren().addAll(loader.load(),btn1,btn);
            } catch (IOException e) {
                e.printStackTrace();
            }



                setGraphic(Box);

        }

        setText("");
    }



}
