package datasource.gui.application;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DataBaseInterfaceGuiBase extends AnchorPane {

    protected final Text employeeDetailsTextLabel;
    protected final Text idTextLabel;
    protected final Text firstNameTextLabel;
    protected final Text lastNameTextLabel;
    protected final Text phoneTextLabel;
    protected final TextField idTextField;
    protected final TextField firstNameTextField;
    protected final TextField lastNameTextField;
    protected final TextField phoneTextField;
    protected final Button nextButton;
    protected final Button previousButton;
    protected final Button firstButton;
    protected final Button lastButton;
    protected final Button newButton;
    protected final Button updateButton;
    protected final Button deleteButton;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private boolean insertFlag = false;

    public DataBaseInterfaceGuiBase(DataSource dataSource) {
        
        
        employeeDetailsTextLabel = new Text();
        idTextLabel = new Text();
        firstNameTextLabel = new Text();
        lastNameTextLabel = new Text();
        phoneTextLabel = new Text();
        idTextField = new TextField();
        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        phoneTextField = new TextField();
        nextButton = new Button();
        previousButton = new Button();
        firstButton = new Button();
        lastButton = new Button();
        newButton = new Button();
        updateButton = new Button();
        deleteButton = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        employeeDetailsTextLabel.setLayoutX(39.0);
        employeeDetailsTextLabel.setLayoutY(44.0);
        employeeDetailsTextLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        employeeDetailsTextLabel.setStrokeWidth(0.0);
        employeeDetailsTextLabel.setText("Employee Details");

        idTextLabel.setLayoutX(45.0);
        idTextLabel.setLayoutY(100.0);
        idTextLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        idTextLabel.setStrokeWidth(0.0);
        idTextLabel.setText("ID");

        firstNameTextLabel.setLayoutX(44.0);
        firstNameTextLabel.setLayoutY(151.0);
        firstNameTextLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        firstNameTextLabel.setStrokeWidth(0.0);
        firstNameTextLabel.setText("First Name");

        lastNameTextLabel.setLayoutX(45.0);
        lastNameTextLabel.setLayoutY(216.0);
        lastNameTextLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        lastNameTextLabel.setStrokeWidth(0.0);
        lastNameTextLabel.setText("Last Name");

        phoneTextLabel.setLayoutX(45.0);
        phoneTextLabel.setLayoutY(285.0);
        phoneTextLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        phoneTextLabel.setStrokeWidth(0.0);
        phoneTextLabel.setText("Phone");

        idTextField.setLayoutX(185.0);
        idTextField.setLayoutY(79.0);

        firstNameTextField.setLayoutX(185.0);
        firstNameTextField.setLayoutY(130.0);

        lastNameTextField.setLayoutX(185.0);
        lastNameTextField.setLayoutY(195.0);

        phoneTextField.setLayoutX(185.0);
        phoneTextField.setLayoutY(264.0);

        nextButton.setLayoutX(20.0);
        nextButton.setLayoutY(332.0);
        nextButton.setMnemonicParsing(false);
        nextButton.setPrefHeight(31.0);
        nextButton.setPrefWidth(71.0);
        nextButton.setText("next");

        previousButton.setLayoutX(102.0);
        previousButton.setLayoutY(332.0);
        previousButton.setMnemonicParsing(false);
        previousButton.setText("previous");

        firstButton.setLayoutX(185.0);
        firstButton.setLayoutY(332.0);
        firstButton.setMnemonicParsing(false);
        firstButton.setPrefHeight(31.0);
        firstButton.setPrefWidth(70.0);
        firstButton.setText("first");

        lastButton.setLayoutX(268.0);
        lastButton.setLayoutY(332.0);
        lastButton.setMnemonicParsing(false);
        lastButton.setPrefHeight(31.0);
        lastButton.setPrefWidth(67.0);
        lastButton.setText("last");

        newButton.setLayoutX(348.0);
        newButton.setLayoutY(332.0);
        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(31.0);
        newButton.setPrefWidth(71.0);
        newButton.setText("new");

        updateButton.setLayoutX(430.0);
        updateButton.setLayoutY(332.0);
        updateButton.setMnemonicParsing(false);
        updateButton.setPrefHeight(31.0);
        updateButton.setPrefWidth(70.0);
        updateButton.setText("update");

        deleteButton.setLayoutX(512.0);
        deleteButton.setLayoutY(332.0);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setText("delete");

        getChildren().add(employeeDetailsTextLabel);
        getChildren().add(idTextLabel);
        getChildren().add(firstNameTextLabel);
        getChildren().add(lastNameTextLabel);
        getChildren().add(phoneTextLabel);
        getChildren().add(idTextField);
        getChildren().add(firstNameTextField);
        getChildren().add(lastNameTextField);
        getChildren().add(phoneTextField);
        getChildren().add(nextButton);
        getChildren().add(previousButton);
        getChildren().add(firstButton);
        getChildren().add(lastButton);
        getChildren().add(newButton);
        getChildren().add(updateButton);
        getChildren().add(deleteButton);
        //Mai's Section
         try
        {    
            connection = dataSource.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            resultSet = statement.executeQuery("select * from employees");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        nextButton.setOnAction(e -> {
                                        try 
                                        {
                                            if(resultSet.next())
                                            {
                                                idTextField.setText(Integer.toString(resultSet.getInt(1)));
                                                lastNameTextField.setText(resultSet.getString(2));
                                                firstNameTextField.setText(resultSet.getString(3));
                                                phoneTextField.setText(resultSet.getString(4));
                                            }
                                        } 
                                        catch (SQLException ex) 
                                        {
                                            Logger.getLogger(DataBaseInterfaceGuiBase.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    });
        
        previousButton.setOnAction(e -> {
                                            try 
                                            {
                                                if(resultSet.previous())
                                                {
                                                    idTextField.setText(Integer.toString(resultSet.getInt(1)));
                                                    lastNameTextField.setText(resultSet.getString(2));
                                                    firstNameTextField.setText(resultSet.getString(3));
                                                    phoneTextField.setText(resultSet.getString(4));
                                                }
                                            } 
                                            catch (SQLException ex) 
                                            {
                                                Logger.getLogger(DataBaseInterfaceGuiBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        });
        
        firstButton.setOnAction(e -> {
                                            try 
                                            {
                                                if(resultSet.first())
                                                {
                                                    idTextField.setText(Integer.toString(resultSet.getInt(1)));
                                                    lastNameTextField.setText(resultSet.getString(2));
                                                    firstNameTextField.setText(resultSet.getString(3));
                                                    phoneTextField.setText(resultSet.getString(4));
                                                }
                                            } 
                                            catch (SQLException ex) 
                                            {
                                                Logger.getLogger(DataBaseInterfaceGuiBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                     });
        
        
        //Islam's Section
        lastButton.setOnAction(e -> {
                                            try 
                                            {
                                                if(resultSet.last())
                                                {
                                                    idTextField.setText(Integer.toString(resultSet.getInt(1)));
                                                    lastNameTextField.setText(resultSet.getString(2));
                                                    firstNameTextField.setText(resultSet.getString(3));
                                                    phoneTextField.setText(resultSet.getString(4));
                                                }
                                            } 
                                            catch (SQLException ex) 
                                            {
                                                Logger.getLogger(DataBaseInterfaceGuiBase.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                     });
        
        
    }
}
