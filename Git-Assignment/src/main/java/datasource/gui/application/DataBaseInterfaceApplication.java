
package datasource.gui.application;

import datasource.database.factory.DataSourceFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.sql.DataSource;


public class DataBaseInterfaceApplication extends Application
{
    private DataSource dataSource = null;
    protected DataBaseInterfaceGuiBase root;
    @Override
    public void start(Stage primaryStage)
    {
        dataSource = DataSourceFactory.getMySQLDataSource();
        root = new DataBaseInterfaceGuiBase(dataSource);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Database Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String args[])
    {
        launch(args);
    }
    
}
