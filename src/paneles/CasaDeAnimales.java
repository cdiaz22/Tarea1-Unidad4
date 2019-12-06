package paneles;

import library.espacio.espaciofisico.Posicion;
import library.espacio.urbano.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class CasaDeAnimales extends JDialog{
    private ParqueDePerros miParqueDePerros = new ParqueDePerros("Dogland");
    private Random random = new Random();
    private JPanel panelPrincipal;
    private JButton pintarButton;
    private JButton quiquiriquiButton;
    private JButton gatoButton;
    private JButton perroButton;
    private JButton cajaButton;
    private JButton silirButton;
    private JButton okButton;
    private JButton cancelButton;

    public CasaDeAnimales(){
        try{
            FileInputStream fileInputStream = new FileInputStream("parque.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            miParqueDePerros = (ParqueDePerros)objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        for (int i = 0; i < miParqueDePerros.getLosObjetos().size() ; i++){
            if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PerroEntity")) {
                PerroControl perroControl = new PerroControl((PerroEntity) miParqueDePerros.getLosObjetos().get(i));
                perroControl.start();
            }
        }

        PintarCasa pintarParqueThread = new PintarCasa(panelPrincipal, miParqueDePerros);
        pintarParqueThread.start();

        setContentPane(panelPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOk();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panelPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        gatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArbolEntity unArbolEntity = new RobleEntity("miArbol" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), miParqueDePerros);
                miParqueDePerros.getLosObjetos().add(unArbolEntity);
                System.out.print(miParqueDePerros);
            }
        });

        perroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PerroEntity unPerroEntity = new PerroEntity("miPerro" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), miParqueDePerros);
                miParqueDePerros.getLosObjetos().add(unPerroEntity);

                PerroControl perroControl = new PerroControl(unPerroEntity);
                perroControl.start();

                System.out.print(miParqueDePerros);
            }
        });

        pintarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image imagenCaja = null;
                Image imagenPerro = null;
                Image imageGato = null;

                try{
                    imagenCaja = ImageIO.read(new File("caja.png"));
                    imageGato = ImageIO.read(new File("gato.png"));
                    imagenPerro = ImageIO.read(new File("perro.png"));
                } catch (IOException ex){
                    ex.printStackTrace();
                }
                panelPrincipal.getGraphics().clearRect(0, 0, 1000, 500);

                for (int i = 0; i < miParqueDePerros.getLosObjetos().size(); i++) {
                    if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PerroEntity")){
                        panelPrincipal.getGraphics().drawImage(imagenPerro,miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getX(), miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getY(),20,10,null);
                    }
                    if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("EncinoEntity")) {
                        panelPrincipal.getGraphics().drawImage(imageGato, miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getX(), miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                    }
                    if (miParqueDePerros.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("RobleEntity")) {
                        panelPrincipal.getGraphics().drawImage(imagenCaja, miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getX(), miParqueDePerros.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                    }
                }
            }
        });
        panelPrincipal.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

            }
        });

        cajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArbolEntity unArbolEntity = new EncinoEntity("miArbol" + random.nextInt(1000), new Posicion(random.nextInt(1000),random.nextInt(500)), miParqueDePerros);
                miParqueDePerros.getLosObjetos().add(unArbolEntity);
                System.out.print(miParqueDePerros);
            }
        });

        quiquiriquiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sonido sonido = new Sonido(new File("gallina.wav"));
                sonido.start();
            }
        });

        silirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void onOk() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("parque.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(miParqueDePerros);
            bufferedOutputStream.flush();

            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CasaDeAnimales dialog = new CasaDeAnimales();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
