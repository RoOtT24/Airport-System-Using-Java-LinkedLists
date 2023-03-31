package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import javafx.scene.control.TableColumn;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;

public class tariq extends Application {
	static LinkedList<Flight> flights = new LinkedList<>();
	private Scene menu;
	private Scene aFlight;
	private Scene aPassenger;
	private Scene scene;
	private Stage stage;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			menu = Menu();
		//	menu.setFill(new ImagePattern(new Image("pp.jpg")));
			aFlight = flightScene();
		//	aFlight.setFill(new ImagePattern(new Image("background_image.jpg")));
			aPassenger = passengerScene();
		//	aPassenger.setFill(new ImagePattern(new Image("p0.jpg")));
			scene = finalScene();
		//	scene.setFill(new ImagePattern(new Image("go.png")));

			menu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(menu);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////
	public void Switch(Scene x) {
		stage.setScene(x);
		stage.setTitle("Project 1|Aziza Karakra");
	}

/////////////////////////////////////////////////////////////
	public Scene flightScene() {

		Group root = new Group();

		Button b1 = new Button();
		b1.setLayoutX(780);
		b1.setLayoutY(500);
		b1.setPrefSize(100, 80);
		/*
		 * Image img2 = new Image("ad.jpg"); ImageView view2 = new ImageView(img2);
		 * view2.setFitHeight(70); view2.setPreserveRatio(true); b1.setGraphic(view2);
		 */

		Button b2 = new Button();
		b2.setLayoutX(10);
		b2.setLayoutY(10);
		b2.setPrefSize(85, 25);
		/*
		 * Image img = new Image("backk.png"); ImageView view = new ImageView(img);
		 * view.setFitHeight(90); view.setPreserveRatio(true); b2.setGraphic(view);
		 */
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b2.isArmed()) {
					Switch(menu);
				}
			}
		});

		Label l1 = new Label("Flight# :");
		l1.setLayoutX(30);
		l1.setLayoutY(125);
		l1.setPrefSize(150, 50);
		l1.setFont(new Font(20));

		TextField txt1 = new TextField();
		txt1.setLayoutX(110);
		txt1.setLayoutY(140);
		txt1.setPrefSize(150, 20);

		Label l2 = new Label("Airline :");
		l2.setLayoutX(30);
		l2.setLayoutY(190);
		l2.setPrefSize(150, 50);
		l2.setFont(new Font(20));

		TextField txt2 = new TextField();
		txt2.setLayoutX(110);
		txt2.setLayoutY(205);
		txt2.setPrefSize(150, 20);

		Label l3 = new Label("Source :");
		l3.setLayoutX(30);
		l3.setLayoutY(255);
		l3.setPrefSize(150, 50);
		l3.setFont(new Font(20));

		TextField txt3 = new TextField();
		txt3.setLayoutX(110);
		txt3.setLayoutY(270);
		txt3.setPrefSize(150, 20);

		Label l4 = new Label("Dest. :");
		l4.setLayoutX(30);
		l4.setLayoutY(320);
		l4.setPrefSize(150, 50);
		l4.setFont(new Font(20));

		TextField txt4 = new TextField();
		txt4.setLayoutX(110);
		txt4.setLayoutY(335);
		txt4.setPrefSize(150, 20);

		Label l5 = new Label("Capacity :");
		l5.setLayoutX(30);
		l5.setLayoutY(385);
		l5.setPrefSize(150, 50);
		l5.setFont(new Font(18));

		TextField txt5 = new TextField();
		txt5.setLayoutX(110);
		txt5.setLayoutY(400);
		txt5.setPrefSize(150, 20);

		Label l6 = new Label();
		l6.setLayoutX(50);
		l6.setLayoutY(440);
		l6.setPrefSize(500, 150);
		l6.setFont(new Font(80));

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b1.isArmed()) {
					if (!(txt1.getText().isEmpty() && txt2.getText().isEmpty() && txt3.getText().isEmpty()
							&& txt4.getText().isEmpty() && txt5.getText().isEmpty())) {
						flights.insertion(new Flight(txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(),
								Integer.parseInt(txt5.getText())));
						txt1.clear();
						txt2.clear();
						txt3.clear();
						txt4.clear();
						txt5.clear();
						l6.setText("Done");
						Image img3 = new Image("smile.png");
						ImageView view3 = new ImageView(img3);
						view3.setFitHeight(100);
						view3.setPreserveRatio(true);
						l6.setGraphic(view3);
					} else {
						l6.setText("Error!");
						Image img1 = new Image("sad.png");
						ImageView view1 = new ImageView(img1);
						view1.setFitHeight(100);
						view1.setPreserveRatio(true);
						l6.setGraphic(view1);

					}
				}

			}

		});

		root.getChildren().addAll(b1, b2, l1, txt1, l2, txt2, l3, txt3, l4, txt4, l5, txt5, l6);
		return new Scene(root, 900, 600);
	}

/////////////////////////////////////////////////////////////////
	public Scene passengerScene() {
		Group root = new Group();

		Button b1 = new Button();
		b1.setLayoutX(780);
		b1.setLayoutY(500);
		b1.setPrefSize(60, 80);
		/*
		 * Image img2 = new Image("add.png"); ImageView view2 = new ImageView(img2);
		 * view2.setFitHeight(70); view2.setPreserveRatio(true); b1.setGraphic(view2);
		 */
		Button b2 = new Button();
		b2.setLayoutX(10);
		b2.setLayoutY(10);
		b2.setPrefSize(85, 25);
		/*
		 * Image img = new Image("backk.png"); ImageView view = new ImageView(img);
		 * view.setFitHeight(90); view.setPreserveRatio(true); b2.setGraphic(view);
		 */		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b2.isArmed()) {
					Switch(menu);
				}
			}
		});

		Label l1 = new Label("Flight# :");
		l1.setLayoutX(20);
		l1.setLayoutY(125);
		l1.setPrefSize(150, 50);
		l1.setFont(new Font(20));
		l1.setTextFill(javafx.scene.paint.Color.BLACK);
		TextField txt1 = new TextField();
		txt1.setLayoutX(150);
		txt1.setLayoutY(140);
		txt1.setPrefSize(150, 20);

		Label l2 = new Label("Ticket# :");
		l2.setLayoutX(20);
		l2.setLayoutY(185);
		l2.setPrefSize(150, 50);
		l2.setFont(new Font(20));
		l2.setTextFill(javafx.scene.paint.Color.BLACK);

		TextField txt2 = new TextField();
		txt2.setLayoutX(150);
		txt2.setLayoutY(200);
		txt2.setPrefSize(150, 20);

		Label l3 = new Label("FullName :");
		l3.setLayoutX(20);
		l3.setLayoutY(245);
		l3.setPrefSize(150, 50);
		l3.setFont(new Font(17));
		l3.setTextFill(javafx.scene.paint.Color.BLACK);

		TextField txt3 = new TextField();
		txt3.setLayoutX(150);
		txt3.setLayoutY(260);
		txt3.setPrefSize(150, 20);

		Label l4 = new Label("Passport :");
		l4.setLayoutX(20);
		l4.setLayoutY(305);
		l4.setPrefSize(150, 50);
		l4.setFont(new Font(18));
		l4.setTextFill(javafx.scene.paint.Color.BLACK);

		TextField txt4 = new TextField();
		txt4.setLayoutX(150);
		txt4.setLayoutY(320);
		txt4.setPrefSize(150, 20);

		Label l5 = new Label("Nationality :");
		l5.setLayoutX(20);
		l5.setLayoutY(365);
		l5.setPrefSize(150, 50);
		l5.setFont(new Font(15));
		l5.setTextFill(javafx.scene.paint.Color.BLACK);

		TextField txt5 = new TextField();
		txt5.setLayoutX(150);
		txt5.setLayoutY(380);
		txt5.setPrefSize(150, 20);

		Label l6 = new Label("Bdate :");
		l6.setLayoutX(20);
		l6.setLayoutY(425);
		l6.setPrefSize(150, 50);
		l6.setFont(new Font(20));
		l6.setTextFill(javafx.scene.paint.Color.BLACK);

		TextField txt6 = new TextField();
		txt6.setLayoutX(150);
		txt6.setLayoutY(440);
		txt6.setPrefSize(150, 20);

		Label l7 = new Label();
		l7.setLayoutX(120);
		l7.setLayoutY(480);
		l7.setPrefSize(400, 50);
		l7.setFont(new Font(40));
		l7.setTextFill(javafx.scene.paint.Color.BLACK);
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b1.isArmed()) {
					if (!(txt1.getText().isEmpty() && txt2.getText().isEmpty() && txt3.getText().isEmpty()
							&& txt4.getText().isEmpty() && txt5.getText().isEmpty() && txt6.getText().isEmpty())) {

						String[] strD = txt6.getText().trim().split("/");
						Passenger p = new Passenger(txt1.getText().trim(), txt2.getText().trim(), txt3.getText().trim(),
								txt4.getText().trim(), txt5.getText().trim(), new Date(Integer.parseInt(strD[2].trim()),
										Integer.parseInt(strD[1].trim()), Integer.parseInt(strD[0].trim())));
						Node<Flight> temp = flights.getHead();
						while (temp != null) {
							if (temp.getData().getFlightNum().equalsIgnoreCase(txt1.getText().trim())) {
								if (temp.getData().getCapacity() <= temp.getData().getNumPassengers()) {
									break;
								} else {
									temp.getData().getPassengers().insertion(p);
									break;
								}
							}
							temp = temp.getNext();
						}
						txt1.clear();
						txt2.clear();
						txt3.clear();
						txt4.clear();
						txt5.clear();
						txt6.clear();
						l7.setText("Done");
						Image img3 = new Image("smile.png");
						ImageView view3 = new ImageView(img3);
						view3.setFitHeight(70);
						view3.setPreserveRatio(true);
						l7.setGraphic(view3);

					} else {
						l7.setText("Error!");
						Image img1 = new Image("sad.png");
						ImageView view1 = new ImageView(img1);
						view1.setFitHeight(70);
						view1.setPreserveRatio(true);
						l7.setGraphic(view1);

					}
				}

			}
		});
		root.getChildren().addAll(b1, b2, l1, txt1, l2, txt2, l3, txt3, l4, txt4, l5, txt5, l6, txt6, l7);
		return new Scene(root, 900, 600);
	}

//////////////////////////////////////////////////////////////////
	public Scene finalScene() {
		Group root = new Group();

		Button b2 = new Button();
		b2.setLayoutX(10);
		b2.setLayoutY(10);
		b2.setPrefSize(85, 50);
		/*
		 * Image img = new Image("g.png"); ImageView view = new ImageView(img);
		 * view.setFitHeight(90); view.setPreserveRatio(true); b2.setGraphic(view);
		 */		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b2.isArmed()) {
					Switch(menu);
				}
			}
		});

		Label l1 = new Label("Flight# :");
		l1.setLayoutX(30);
		l1.setLayoutY(275);
		l1.setPrefSize(150, 50);
		l1.setFont(new Font(40));

		TextField txt1 = new TextField();
		txt1.setLayoutX(210);
		txt1.setLayoutY(281);
		txt1.setPrefSize(430, 50);
		txt1.setFont(new Font(20));

		Button b1 = new Button();
		b1.setLayoutX(300);
		b1.setLayoutY(430);
		b1.setPrefSize(250, 120);

		/*
		 * Image img3 = new Image("sear.png"); ImageView view3 = new ImageView(img3);
		 * view3.setFitHeight(90); view3.setPreserveRatio(true); b1.setGraphic(view3);
		 */

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b1.isArmed() && !(txt1.getText().isEmpty())) {
					Node<Flight> temp = flights.getHead();
					while (temp != null) {
						if (temp.getData().getFlightNum().equalsIgnoreCase(txt1.getText().trim())) {
							Group root1 = new Group();

							TableView<Passenger> tv = new TableView<>();
// tv.getItems().addAll(temp.getData());
							tv.setLayoutX(200);
							tv.setLayoutY(100);
							tv.setPrefSize(533, 450);
//ObservableList<Passenger> p = FXCollections.observableList(temp.getData().getPassengers());
//tv.setItems((ObservableList<Passenger>) temp.getData().getPassengers());
							
							/*
							 * tv.getColumns().addAll(new TableColumn("Flight Number"), new
							 * TableColumn("Ticket Number"), new TableColumn("FullName"), new
							 * TableColumn("Passport Number"), new TableColumn("Nationality"), new
							 * TableColumn("Birth Date"));
							 */
							 
							tv.setEditable(true);
							TableColumn<Passenger, String> fn = new TableColumn<Passenger, String>("Flight Number");
							fn.setCellValueFactory(new PropertyValueFactory<Passenger , String>("FlightNum"));
							TableColumn<Passenger, String> tn = new TableColumn<Passenger, String>("Ticket Number");
							tn.setCellValueFactory(new PropertyValueFactory<Passenger , String>("TicketNum"));
							TableColumn<Passenger, String> f = new TableColumn<Passenger, String>("FullName");
							f.setCellValueFactory(new PropertyValueFactory<Passenger , String>("FullName"));
							TableColumn<Passenger, String> pn = new TableColumn<Passenger, String>("Passport Number");
							pn.setCellValueFactory(new PropertyValueFactory<Passenger , String>("PassportNum"));
							TableColumn<Passenger, String> n = new TableColumn<Passenger, String>("Nationality");
							n.setCellValueFactory(new PropertyValueFactory<Passenger , String>("Nationality")) ;
							//n.setCellValueFactory(new PropertyValueFactory<>("Nationality"));
							TableColumn<Passenger, String> bd = new TableColumn<Passenger, String>("Birth Date");
							//bd.setCellValueFactory(new PropertyValueFactory<>("Bdate"));
							
							tv.getColumns().addAll(fn, tn, f, pn, n, bd);
							Node<Passenger> p = temp.getData().getPassengers().getHead();
							while (p != null) {

								tv.getItems().add(p.getData());
								p = p.getNext();
								//System.out.println("hi");
							}
//System.out.println("hello");
							Button b3 = new Button();
							b3.setLayoutX(10);
							b3.setLayoutY(10);
							b3.setPrefSize(30, 15);
							/*
							 * Image img = new Image("back1.png"); ImageView view = new ImageView(img);
							 * view.setFitHeight(90); view.setPreserveRatio(true); b3.setGraphic(view);
							 */
							b3.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
									if (b3.isArmed()) {
										Switch(scene);
									}
								}
							});
							root1.getChildren().addAll(b3, tv);
							Switch(new Scene(root1, 900, 600));
						}
						temp = temp.getNext();
					}
					txt1.clear();
				}

			}
		});

		Label l6 = new Label();
		l6.setLayoutX(110);
		l6.setLayoutY(375);
		l6.setPrefSize(500, 200);
		l6.setFont(new Font(90));

		root.getChildren().addAll(b2, l1, txt1, l6, b1);
		return new Scene(root, 900, 600);
	}

/////////////////////////////////////////////////////////////////
	public Scene Menu() {

		Group root = new Group();

		Button b1 = new Button(" New Flight");
		b1.setLayoutX(20);
		b1.setLayoutY(50);
		b1.setPrefSize(340, 60);
		b1.setFont(new Font(23));
		//Image img2 = new Image("fl.jpg");
		//ImageView view2 = new ImageView(img2);
		//view2.setFitHeight(110);
		//view2.setPreserveRatio(true);
		//b1.setGraphic(view2);

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b1.isArmed()) {
					Switch(aFlight);
				}
			}
		});

		Button b2 = new Button("New Passenger");
		b2.setLayoutX(20);
		b2.setLayoutY(200);
		b2.setPrefSize(350, 90);
		b2.setFont(new Font(23));
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b2.isArmed()) {
					Switch(aPassenger);
				}
			}
		});
/////////////////////////////////////////////
		/*
		 * Image img = new Image("pass.jpg"); ImageView view = new ImageView(img);
		 * view.setFitHeight(100); view.setPreserveRatio(true);
		 * 
		 * b2.setGraphic(view);
		 */

/////////////////////////////////////////////

		Button b3 = new Button("Search");
		b3.setLayoutX(20);
		b3.setLayoutY(340);
		b3.setPrefSize(350, 90);
		b3.setFont(new Font(23));
		/*
		 * Image img3 = new Image("sear.png"); ImageView view3 = new ImageView(img3);
		 * view3.setFitHeight(100); view3.setPreserveRatio(true); b3.setGraphic(view3);
		 */
		b3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
// TODO Auto-generated method stub
				if (b3.isArmed()) {
					Switch(scene);
				}
			}
		});

		root.getChildren().addAll(b1, b2, b3);
		stage.setTitle("Project 1|Aziza Karakra");
		return new Scene(root, 900, 600);
	}

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("Flights.txt");
		Scanner input = new Scanner(f);
		while (input.hasNextLine()) {

			String[] str = input.nextLine().trim().split(",");

			flights.insertion(new Flight(str[0], str[1], str[2], str[3], Integer.parseInt(str[4])));
		}
		input.close();
		f = new File("Passengers.txt");
		input = new Scanner(f);
		while (input.hasNextLine()) {

			String[] str = input.nextLine().trim().split(",");
			String[] strD = str[5].trim().split("/");
			Passenger p = new Passenger(str[0], str[1], str[2], str[3], str[4],
					new Date(Integer.parseInt(strD[2].trim()), Integer.parseInt(strD[1].trim()),
							Integer.parseInt(strD[0].trim())));
			Node<Flight> temp = flights.getHead();
			while (temp != null) {
				if (temp.getData().getFlightNum().equalsIgnoreCase(str[0])) {
					if (temp.getData().getCapacity() <= temp.getData().getNumPassengers()) {
						break;
					} else {
						temp.getData().getPassengers().insertion(p);
						break;
					}
				}
				temp = temp.getNext();
			}

		}
		launch(args);
		System.out.println(flights.toString());
	}
}