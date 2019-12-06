package library.espacio.urbano;

public class PerroControl extends Thread{
    private PerroEntity perroEntity = null;

    public PerroControl(PerroEntity perroEntity) {
        this.perroEntity = perroEntity;
    }

    @Override
    public void run() {
        int incrementoX = 1;
        int incrementoY = 1;

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (perroEntity.getLaPosicion().getX() >= 1000){
                incrementoX = -1;
            }
            if (perroEntity.getLaPosicion().getY() >= 500){
                incrementoY = -1;
            }
            if (perroEntity.getLaPosicion().getX() <= 0){
                incrementoX = 1;
            }
            if (perroEntity.getLaPosicion().getY() <= 0){
                incrementoY = 1;
            }
            perroEntity.getLaPosicion().setX(perroEntity.getLaPosicion().getX() + incrementoX);
            perroEntity.getLaPosicion().setY(perroEntity.getLaPosicion().getY() + incrementoY);
        }
    }
}
