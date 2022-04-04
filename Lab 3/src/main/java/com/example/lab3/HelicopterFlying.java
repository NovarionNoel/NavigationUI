package com.example.lab3;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Integer.parseInt;


public class HelicopterFlying extends Application {

    //refreshes the combobox based on locations in loc arraylist
    public static void PopulateList(ArrayList<Location> arrayList, ComboBox comboBox) {
        comboBox.getItems().clear();
        for (int y=0;y<arrayList.size();y++)
        {
            String s1 =arrayList.get(y).getPlace();

            comboBox.getItems().add(s1);

        }

        }

    //Updates Current Location information on UI elements
    public static void UpdateLocation (Label where, Label c1, Label c2, Label gasStation, Helicopter heli){
        where.setText(heli.getCurrent().getPlace());
        c1.setText(String.valueOf(heli.getCurrent().getCoordinateX()));
        c2.setText(String.valueOf(heli.getCurrent().getCoordinateY()));
        boolean b1 = heli.getCurrent().isGas();

        if (b1 == true) {
            gasStation.setText("Yes");
        }
        else if (b1 == false) {
            gasStation.setText("No");
        }
    }

    //Updates Selected Location Information on UI elements
    public static void FlyToLocation(Label whereTo, Label c1,Label c2, Label gasStation, ComboBox comboBox, ArrayList<Location> locations){
      try{ int a= comboBox.getSelectionModel().getSelectedIndex();
        whereTo.setText(locations.get(a).getPlace());
        c1.setText(String.valueOf(locations.get(a).getCoordinateX()));
       c2.setText(String.valueOf(locations.get(a).getCoordinateY()));
       gasStation.setText("No");
       if (locations.get(a).isGas()==true){
           gasStation.setText("Yes");
        }}
      catch (IndexOutOfBoundsException e){
          int a =0;
          whereTo.setText(locations.get(a).getPlace());
          c1.setText(String.valueOf(locations.get(a).getCoordinateX()));
          c2.setText(String.valueOf(locations.get(a).getCoordinateY()));
          gasStation.setText("No");
          if (locations.get(a).isGas()==true){
              gasStation.setText("Yes");
                                            }
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        //initial list of locations
        ArrayList<Location> loc = new ArrayList<>();
        loc.add(new Location("Cleveland", 0, 0, true));
        loc.add(new Location("North Pole", 500, -100,true));
        loc.add(new Location("Campbell Hill",-50,-50,false));
        loc.add(new Location("Tokyo",-100,1000,true));
        loc.add(new Location("Chicago",-200,75,true));
        loc.add(new Location("Erie PA", 150,0,true));
        loc.add(new Location("Allegheny National Forest",300,-75,false));



        //initial scene declarations
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Helicopter Trips");
        stage.setScene(scene);
        stage.show();
        AnchorPane locAdd = new AnchorPane();
        Scene editLoc = new Scene(locAdd, 800, 600);

        //root scene text
        Label intro = new Label("Welcome to Helicopter Trips. Let's play!");
        AnchorPane.setBottomAnchor(intro,50.0);
        AnchorPane.setLeftAnchor(intro,220.0);

        //addLoc scene text
        Label locEdit = new Label();
        AnchorPane.setBottomAnchor(locEdit, 50.0);
        AnchorPane.setLeftAnchor(locEdit,260.0);

        //textfield group for root
        TextField tf1 = new TextField();
        AnchorPane.setTopAnchor(tf1,200.0);
        AnchorPane.setLeftAnchor(tf1,60.0);

        TextField tf2= new TextField();
        AnchorPane.setTopAnchor(tf2,230.0);
        AnchorPane.setLeftAnchor(tf2, 60.0);

        //textfield group for addLoc
        TextField tf3= new TextField();
        AnchorPane.setTopAnchor(tf3,260.0);
        AnchorPane.setLeftAnchor(tf3,60.0);

        TextField tf4 = new TextField();
        AnchorPane.setTopAnchor(tf4,200.0);
        AnchorPane.setLeftAnchor(tf4,60.0);

        TextField tf5= new TextField();
        AnchorPane.setTopAnchor(tf5,230.0);
        AnchorPane.setLeftAnchor(tf5, 60.0);

        //label group for root scene
        Label gLb1= new Label("MPG");
        AnchorPane.setTopAnchor(gLb1,202.0);
        AnchorPane.setLeftAnchor(gLb1, 20.0);

        Label gLb2= new Label("TANK");
        AnchorPane.setTopAnchor(gLb2,232.0);
        AnchorPane.setLeftAnchor(gLb2, 20.0);

        Label gLb3 = new Label();
        AnchorPane.setTopAnchor(gLb3,202.0);
        AnchorPane.setLeftAnchor(gLb3,60.0);

        Label gLb4 = new Label();
        AnchorPane.setTopAnchor(gLb4, 232.0);
        AnchorPane.setLeftAnchor(gLb4, 60.0);

        //label group for addLoc scene
        Label gLb5 =new Label();
        AnchorPane.setTopAnchor(gLb5,202.0);
        AnchorPane.setLeftAnchor(gLb5, 60.0);

        Label gLb6 = new Label();
        AnchorPane.setTopAnchor(gLb6,232.0);
        AnchorPane.setLeftAnchor(gLb6, 60.0);

        Label gLb7 = new Label();
        AnchorPane.setTopAnchor(gLb7,262.0);
        AnchorPane.setLeftAnchor(gLb7,60.0);

        Label gLb8 = new Label();
        AnchorPane.setTopAnchor(gLb8, 292.0);
        AnchorPane.setLeftAnchor(gLb8, 60.0);

        Label gLb9 = new Label();
        AnchorPane.setTopAnchor(gLb9, 262.0);
        AnchorPane.setLeftAnchor(gLb9, 20.0);

        Label gLb10 = new Label();
        AnchorPane.setTopAnchor(gLb10, 292.0);
        AnchorPane.setLeftAnchor(gLb10, 20.0);

        Label gLb11 = new Label();
        AnchorPane.setTopAnchor(gLb11,202.0);
        AnchorPane.setLeftAnchor(gLb11, 20.0);

        Label gLb12 = new Label();
        AnchorPane.setTopAnchor(gLb12,232.0);
        AnchorPane.setLeftAnchor(gLb12, 20.0);

        //button controls for heli and scene swap
        Button start = new Button ("Start");
        AnchorPane.setLeftAnchor(start, 360.0);
        AnchorPane.setBottomAnchor(start,20.0);

        Button adv = new Button("Continue");
        AnchorPane.setLeftAnchor(adv, 360.0);
        AnchorPane.setBottomAnchor(adv,20.0);

        Button fly = new Button("Fly");
        AnchorPane.setLeftAnchor(fly,360.0);
        AnchorPane.setBottomAnchor(fly, 20.0);

        Button addNew = new Button("Add New");
        AnchorPane.setRightAnchor(addNew,60.0);
        AnchorPane.setTopAnchor(addNew,420.0);

        Button remove = new Button ("Remove");
        AnchorPane.setRightAnchor(remove, 60.0);
        AnchorPane.setTopAnchor(remove,460.0);

        Button conf = new Button("Yes");
        AnchorPane.setLeftAnchor(conf, 340.0);
        AnchorPane.setBottomAnchor(conf,20.0);

        Button deny = new Button("No");
        AnchorPane.setLeftAnchor(deny, 380.0);
        AnchorPane.setBottomAnchor(deny,20.0);

        Button adv2 = new Button("Add?");
        AnchorPane.setLeftAnchor(adv2, 340.0);
        AnchorPane.setBottomAnchor(adv2,20.0);

        Button adv3 = new Button ("No");
        AnchorPane.setLeftAnchor(adv3,380.0);
        AnchorPane.setBottomAnchor(adv3, 20.0);

        Button adv4 = new Button("Yes");
        AnchorPane.setLeftAnchor(adv4,340.0);
        AnchorPane.setBottomAnchor(adv4, 20.0);

        //information about where heli currently is
        Button refuel = new Button ("Refuel?");
        AnchorPane.setLeftAnchor(refuel, 90.0);
        AnchorPane.setTopAnchor(refuel, 140.0);

        Label X = new Label("X: ");
        AnchorPane.setTopAnchor(X, 102.0);
        AnchorPane.setLeftAnchor(X,20.0);

        Label Y = new Label("Y: ");
        AnchorPane.setLeftAnchor(Y,20.0);
        AnchorPane.setTopAnchor(Y, 122.0);

        Label gas = new Label ("GAS?");
        AnchorPane.setLeftAnchor(gas,20.0);
        AnchorPane.setTopAnchor(gas, 142.0);

        Label in = new Label ("IN: ");
        AnchorPane.setTopAnchor(in, 80.0);
        AnchorPane.setLeftAnchor(in,20.0);

        Label where = new Label();
        AnchorPane.setTopAnchor(where, 80.0);
        AnchorPane.setLeftAnchor(where,60.0);

        Label c1 = new Label();
        AnchorPane.setTopAnchor(c1, 102.0);
        AnchorPane.setLeftAnchor(c1,60.0);

        Label c2 = new Label();
        AnchorPane.setLeftAnchor(c2,60.0);
        AnchorPane.setTopAnchor(c2, 122.0);

        Label gasStation = new Label();
        AnchorPane.setLeftAnchor(gasStation,60.0);
        AnchorPane.setTopAnchor(gasStation, 142.0);

        //Label group for FlyToLocation
        Label To = new Label("TO:");
        AnchorPane.setTopAnchor(To, 80.0);
        AnchorPane.setLeftAnchor(To,210.0);

        Label whereTo = new Label();
        AnchorPane.setTopAnchor(whereTo, 80.0);
        AnchorPane.setLeftAnchor(whereTo,250.0);

        Label c1To= new Label();
        AnchorPane.setTopAnchor(c1To, 102.0);
        AnchorPane.setLeftAnchor(c1To,250.0);

        Label c2To= new Label();
        AnchorPane.setLeftAnchor(c2To,250.0);
        AnchorPane.setTopAnchor(c2To, 122.0);

        Label XTo = new Label("X: ");
        AnchorPane.setTopAnchor(XTo, 102.0);
        AnchorPane.setLeftAnchor(XTo,210.0);

        Label YTo = new Label("Y: ");
        AnchorPane.setLeftAnchor(YTo,210.0);
        AnchorPane.setTopAnchor(YTo, 122.0);

        Label gasTo = new Label ("GAS?");
        AnchorPane.setLeftAnchor(gasTo,210.0);
        AnchorPane.setTopAnchor(gasTo, 142.0);

        Label gasStationTo = new Label();
        AnchorPane.setLeftAnchor(gasStationTo,250.0);
        AnchorPane.setTopAnchor(gasStationTo, 142.0);
        ObservableList<String> gStation = FXCollections.observableArrayList(
        "Yes",
             "No"
        );


        //lets user select if a new location has gas or not
        final ComboBox gasBox = new ComboBox<>(gStation);
        AnchorPane.setLeftAnchor(gasBox,60.0);
        AnchorPane.setTopAnchor(gasBox, 290.0);

        //lets user select different locations to fly to
        ObservableList<String> options = FXCollections.observableArrayList(
                );
        final ComboBox comboBox= new ComboBox<>(options);



        AnchorPane.setRightAnchor(comboBox,60.0);
        AnchorPane.setTopAnchor(comboBox, 60.0);

        //initialized variables for various functions

        //initial helicopter before being properly set to user values
        Helicopter heli= new Helicopter(0,0,loc.get(0));
        //creation of user generated helicopter in adv
        AtomicInteger MPG = new AtomicInteger();
        AtomicInteger Tank = new AtomicInteger();

        //used in removing a location
        AtomicInteger selected = new AtomicInteger( 0);
        AtomicReference<String> locName = new AtomicReference<>();

        //start button
        start.setOnAction(actionEvent -> {
        intro.setText("Create your helicopter by giving the desired MPG and tank size.");
        root.getChildren().addAll(adv, tf1, tf2, gLb1, gLb2);
        root.getChildren().remove(start);
            }
        );

        //initial location list content
        PopulateList(loc,comboBox);

   //button to create helicopter and begin the game
    adv.setOnAction(actionEvent1 -> {
    try {
        //Gathers text input from user about the helicopter
        MPG.set(parseInt(tf1.getText()));
        Tank.set(parseInt(tf2.getText()));
        root.getChildren().removeAll(tf1, tf2, adv);
        gLb3.setText(String.valueOf(MPG.get()));
        gLb4.setText(String.valueOf(Tank.get()));

        //sets the helicopter information and uses it to produce UI elements
        heli.setFuelCapacity(Double.parseDouble(String.valueOf(Tank.get())));
        heli.setCurrentFuel(heli.getFuelCapacity());
        heli.setMPG(MPG.get());
        UpdateLocation(where, c1, c2, gasStation, heli);
        root.getChildren().addAll(gLb3, gLb4, fly, addNew, comboBox, remove, refuel, c1, c2, gasStation, where, Y, X, gas, in,XTo, YTo, gasTo, gasStationTo,c1To,c2To,whereTo,To);
        intro.setText("Choose from the following list or change the places you can fly.");

    } catch (Exception e) {
        intro.setText("Numbers only, try again!");
    }
});

    //displays the location information of the currently selected location
    comboBox.setOnAction(actionEvent -> {
    FlyToLocation(whereTo,c1To,c2To,gasStationTo, comboBox, loc);
    });

        //refuel button
        refuel.setOnAction(actionEvent -> {
        intro.setText(heli.Refuel());
        gLb4.setText(String.valueOf(heli.getCurrentFuel()));
                                        });

        //button to fly to another location
        fly.setOnAction(actionEvent -> {
            try{
             intro.setText(heli.Travel(loc.get(comboBox.getSelectionModel().getSelectedIndex())));
             gLb4.setText(String.valueOf(heli.getCurrentFuel()));
             UpdateLocation(where,c1,c2,gasStation,heli);
            }
            catch (Exception e){
                intro.setText("Make sure to select a location first!");
            }


        });

        root.getChildren().addAll(intro, start);

        //initial location remove attempt
        remove.setOnAction(actionEvent -> {
            try {
                selected.set(comboBox.getSelectionModel().getSelectedIndex());
                locName.set(loc.get(selected.get()).getPlace());
                intro.setText("Are you sure you want to remove " + locName.get() + "?");
                root.getChildren().addAll(conf, deny);
                root.getChildren().remove(fly);
            }
        catch (Exception e){
                intro.setText("Make sure you select a location before trying to remove it!");
        }
        });

        //remove location
        conf.setOnAction(actionEvent -> {
            intro.setText(locName.get()+" removed. Choose from the following list or change the places you can fly");
            root.getChildren().add(fly);
            root.getChildren().removeAll(conf,deny);
            loc.remove(selected.get());
            PopulateList(loc,comboBox);
        });

        //don't remove location
        deny.setOnAction(actionEvent -> {
            intro.setText(locName.get()+" not removed. Choose from the following list or change the places you can fly");
            root.getChildren().add(fly);
            root.getChildren().removeAll(conf, deny);

        });

        //swap to locAdd scene
        addNew.setOnAction(actionEvent -> {
            locEdit.setText("Create your location! Don't forget to name it.");
            stage.setScene(editLoc);
            gLb11.setText("Name");
            gLb12.setText("X");
            gLb9.setText("Y");
            gLb10.setText("Gas?");
            locAdd.getChildren().addAll(tf3, tf4, tf5, gasBox, gLb11, gLb12, gLb9, gLb10, adv2, locEdit);

        });

        //locAdd scene control
        AtomicInteger gSet=new AtomicInteger(2);

        gasBox.setOnAction(actionEvent1 -> {
            int yn=gasBox.getSelectionModel().getSelectedIndex();
            gSet.set(yn);
        });



        Location nLoc = new Location();

        //initial location submission
  adv2.setOnAction(actionEvent ->
       {
           try {
               //retrieves user input
               String a = tf4.getText();
               int x1 = parseInt(tf5.getText());
               int y1 = parseInt(tf3.getText());

               //sets location properties to collected input
               nLoc.setPlace(a);
               nLoc.setCoordinateX(x1);
               nLoc.setCoordinateY(y1);
               if (gSet.get() == 0) {
                   nLoc.setGas(true);
                   gLb8.setText("Yes");
               }
               else if (gSet.get()==1) {
                   nLoc.setGas(false);
                   gLb8.setText("No");
               }

               //updates UI for confirmation
               locAdd.getChildren().removeAll(tf4, tf5, tf3, gasBox,adv2);
               gLb5.setText(a);
               gLb6.setText(String.valueOf(x1));
               gLb7.setText(String.valueOf(y1));
               locAdd.getChildren().addAll(gLb5, gLb6, gLb7, gLb8, adv3, adv4);
               locEdit.setText("Do you want to add this location?");

           }

           catch (NumberFormatException e) {
               locEdit.setText("Uh oh! Make sure you only use numbers for X and Y coordinates.");
                                            }



       }
       );


  //confirm location
       adv4.setOnAction(actionEvent1 -> {
            try {
                loc.add(nLoc);
                PopulateList(loc, comboBox);
                gSet.set(2);
                locAdd.getChildren().removeAll(gLb5,gLb6,gLb7,gLb8,adv3,adv2,adv4, gLb9, gLb10, gLb11, gLb12,locEdit);
                stage.setScene(scene);
                intro.setText(nLoc.getPlace() + " added! Choose from the following list, or change the places you can fly.");

            }
            catch (Exception e){
                locEdit.setText("Something is wrong, please edit your location.");
            }


       });

        //go back and edit location
        adv3.setOnAction(actionEvent -> {
            locAdd.getChildren().removeAll(gLb5,gLb6,gLb7,gLb8,adv3,adv4);
            locAdd.getChildren().addAll(tf4,tf5,tf3,gasBox,adv2);
            locEdit.setText("Create your location!");


        }
        );


    }

    public static void main(String[] args) {
        launch();
    }
}