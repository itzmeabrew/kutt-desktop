package kutt;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class qr_codeController implements Initializable
{

    @FXML
    private ImageView qr_image;

    @FXML
    private JFXButton save_qr,exit;
    
    private void qrcode()
    {
    	Image im=new Image("https://api.qrserver.com/v1/create-qr-code/?size=100x100&data=Example");
    	qr_image.setImage(im);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		qrcode();
	}

}