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
			admin.papel = Papel.ADMIN;
			admin.save();
		}
    }
}
