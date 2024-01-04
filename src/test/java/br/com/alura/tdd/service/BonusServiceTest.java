package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(25000))));
        /*
        *Outra implementação para captura de exception no Junit: utilizando um try catch*
        try{
        *   service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(25000)));
        *   Assertions.fail("Nao deu a exception!");
        * }catch(Exception e){
        *   Assertions.assertEquals("Funcionario com salario maior do que 10000 reais não pode receber bonus!", e.getMessage);
        * }
         */
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(2500)));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal(10000)));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
