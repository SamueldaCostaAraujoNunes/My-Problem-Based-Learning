import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A classe <b>TestController</b>, tem como função executar todas as classes testes do projeto.
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestFila.class,
        TestFilaPaciente.class,
        TestListaEncadeada.class,
        TestListaGeralExames.class,
        TestListaMedicos.class,
        TestMedico.class 
})

public class TestController {
}


