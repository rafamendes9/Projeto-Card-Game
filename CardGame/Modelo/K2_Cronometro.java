package Modelo;

public class K2_Cronometro {
    private int minutos;
    private int segundos;
    private boolean rodando;

    public K2_Cronometro() {
        this.minutos = 0;
        this.segundos = 0;
        this.rodando = false;
    }

    public void iniciar() {
        rodando = true;
        Thread thread = new Thread(() -> {
            while (rodando) {
                try {
                    Thread.sleep(1000); // Aguarda 1 segundo
                    segundos++;
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                    System.out.printf("%02d:%02d%n", minutos, segundos);
                    if (minutos == 3) {
                        rodando = false;
                        throw new J3_TimeOutException();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (J3_TimeOutException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        thread.start();
    }

    public void parar() {
        rodando = false;
    }
}