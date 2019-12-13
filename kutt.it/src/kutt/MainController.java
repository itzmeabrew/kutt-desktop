package kutt;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.json.JSONObject;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController implements Initializable
{
	String xrslt;
	
    @FXML
    private TextField url;

    @FXML
    private Text rslt,is_copy;

    @FXML
    private JFXButton copy,setting,qr,btn_exec;
    
    api_handler api = new api_handler();
    
    
    @FXML
    private void kutt_it(ActionEvent event) 
    {
    	String response,txt_url;
    	
    	txt_url=url.getText();
    	
    	response=api.sendPost(txt_url, "", "", false);
    	JSONObject obj = new JSONObject(response);
    	xrslt=obj.getString("shortLink");
    	rslt.setText(xrslt);
    }
    
    @FXML
    private void copy_clip(ActionEvent event) 
    {
    	StringSelection stringSelection = new StringSelection(xrslt);
    	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    	clipboard.setContents(stringSelection, null);
    	is_copy.setText("Copied to clipboard");
    }
    
    @FXML
    private void qrcode(ActionEvent event)
    {
		try 
		{
			Stage stage =  new Stage();
			AnchorPane qr_code = (AnchorPane)FXMLLoader.load(getClass().getResource("qr_code.fxml"));
			Scene scene = new Scene(qr_code,427,400);
			stage.setScene(scene);
			stage.setTitle("QR Generator");
			stage.show();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		// TODO Auto-generated method stub
	}
}
