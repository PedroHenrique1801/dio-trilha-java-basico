public abstract class Relogio {
    protected int hora;
    protected int minuto;
    protected int segundo;

    public abstract void sincronizar(Relogio outroRelogio);

    public String obterHoraFormatada() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public int getSegundo() { return segundo; }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto < 60) this.minuto = minuto;
        else throw new IllegalArgumentException("Minuto inválido");
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo < 60) this.segundo = segundo;
        else throw new IllegalArgumentException("Segundo inválido");
    }
}

public class RelogioBrasileiro extends Relogio {
    
    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora <= 23) this.hora = hora;
        else throw new IllegalArgumentException("Hora inválida para o padrão brasileiro (0-23)");
    }

    @Override
    public void sincronizar(Relogio outroRelogio) {
        this.setHora(outroRelogio.getHora());
        this.setMinuto(outroRelogio.getMinuto());
        this.setSegundo(outroRelogio.getSegundo());
    }
}

public class RelogioAmericano extends Relogio {
    private String periodo; // "AM" ou "PM"

    public RelogioAmericano(int hora, int minuto, int segundo, String periodo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
        this.periodo = periodo.toUpperCase();
    }

    public void setHora(int hora) {
        // Restringe as horas de 1 a 12
        if (hora >= 1 && hora <= 12) this.hora = hora;
        else throw new IllegalArgumentException("Hora inválida para padrão americano (1-12)");
    }

    public String getPeriodo() { return periodo; }

    @Override
    public String obterHoraFormatada() {
        // Sobrescreve para incluir o AM/PM
        return super.obterHoraFormatada() + " " + periodo;
    }

    @Override
    public void sincronizar(Relogio outroRelogio) {
        this.setMinuto(outroRelogio.getMinuto());
        this.setSegundo(outroRelogio.getSegundo());

        int horaExterna = outroRelogio.getHora();
        
        if (horaExterna == 0) {
            this.setHora(12);
            this.periodo = "AM";
        } else if (horaExterna > 12) {
            this.setHora(horaExterna - 12);
            this.periodo = "PM";
        } else if (horaExterna == 12) {
            this.setHora(12);
            this.periodo = "PM";
        } else {
            this.setHora(horaExterna);
            this.periodo = "AM";
        }
    }
}
