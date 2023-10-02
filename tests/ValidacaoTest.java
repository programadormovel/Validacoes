public class ValidacaoTest extends TestCase {

    @Test
    public static void deveValidarCPFComSucesso(){
        String cpf = "11111111111";
        Mockito.spy(sucesso);
        boolean sucesso = Util.validaCPF(cpf);
        assertIsTrue(sucesso);
    }

    @Test
    public static void naoDeveValidarCPFComSucesso(){
        String cpf = "11111111112";
        Mockito.spy(sucesso);
        boolean sucesso = Util.validaCPF(cpf);
        assertIsFalse(sucesso);
    }

    @Test
    public static void deveCriticarCPFComTamanhoMenorQue11Caracteres(){
        String cpf = "111111111";
        Mockito.spy(sucesso);
        boolean sucesso = Util.validaCPF(cpf);
        assertIsFalse(sucesso);
    }
}