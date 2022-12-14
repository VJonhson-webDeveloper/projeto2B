package jobs;

import models.Operador;
import models.Papel;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;

@OnApplicationStart
public class Inicializador extends Job {
    
    @Override
    public void doJob() throws Exception {
		if (Operador.count() == 0) {
			Operador admin = new Operador();
			admin.email = "1frnm33t1ngs@ifrn.edu.br";
			admin.senha = Crypto.passwordHash("thebestones");
			admin.papel = Papel.ADMIN;
			admin.save();
		}
    }
}
