public interface ServicoMensagem {
    void enviar(String mensagem);
}

public class Sms implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

public class Email implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando E-mail: " + mensagem);
    }
}

public class RedesSociais implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Publicando nas Redes Sociais: " + mensagem);
    }
}

public class WhatsApp implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando mensagem no WhatsApp: " + mensagem);
    }
}

public class DisparadorDeMarketing {
    
    public void enviarCampanha(String mensagem, List<ServicoMensagem> canais) {
        for (ServicoMensagem canal : canais) {
            canal.enviar(mensagem);
        }
    }
}
