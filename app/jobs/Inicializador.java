package jobs;

import models.Papel;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;

@OnApplicationStart
public class Inicializador extends Job {
    
    @Override
    public void doJob() throws Exception {
		if (Usuario.count() == 0) {
			Usuario admin = new Usuario();
			admin.email = "ifrn@ifrn.edu.br";
			admin.senha = Crypto.passwordHash("ifrn");
			admin.nome = "Administrador do projeto de extensão";
			admin.telefone = "(84) 91111-0000";
			admin.cpf = "111.222.333-04";
			admin.perfil = "Servidor do IFRN";
			admin.cidade = "Natal";
			admin.estado = "Rio Grande do Norte";
			admin.idade = "Desconhecida";
			admin.escolaridade = "Desconhecida";
			admin.papel = Papel.ADMIN;
			admin.save();
		}
    }
}
