package paneles;

import library.espacio.urbano.ParqueDePerros;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PintarCasa extends Thread{
    private Image imagenGato = null;
    private Image imagenPerro = null;
    private Image imagenCaja = null;
    private JPanel panelPrincipal;
    private ParqueDePerros miParqueDePerros;

    public PintarCasa(JPanel panelPrincipal, ParqueDePerros miParqueDePerros){
        this.panelPrincipal = panelPrincipal;
        this.miParqueDePerros = miParqueDePerros;
    }

    public void run(){
        System.out.println("Pintar parque thread inicializado");

        try{
            imagenCaja = ImageIO.read(new File("caja.png"));
            imagenGato = ImageIO.read(new File("gato.png"));
            imagenPerro = ImageIO.read(new File("perro.png"));
        } catch (IOException ex){
            ex.printStackTrace();
        }
        while (true){

            try{
                Thread.sleep(220);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            panelPrincipal.getGraphics().clearRect(0, 0, 1000, 500);

            for (int i = 0; i < miParqueDePerros.getLosObjetos().size(); i++) {
                if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PerroEntity")){
                    panelPrincipal.getGraphics().drawImage(imagenPerro,miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getX(), miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getY(),20,10,null);
                }
                if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("EncinoEntity")) {
                    panelPrincipal.getGraphics().drawImage(imagenGato, miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getX(), miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                }
                if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("RobleEntity")) {
                    panelPrincipal.getGraphics().drawImage(imagenCaja, miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getX(), miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                }
            }
        }
    }
}
