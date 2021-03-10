/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import challenge.business.BusinessFactory;
import challenge.business.DressBusiness;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Gustavo
 */
public class ConsoleRemocao extends BaseConsole {
    
    @Override
    public boolean execute() {
        System.out.println("Informe o código da roupa: ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        
        try {
            int code = Integer.parseInt(reader.readLine());
            BusinessFactory<DressBusiness> factory = new BusinessFactory<DressBusiness>(DressBusiness.class);
            DressBusiness business = factory.getInstante();
            
            business.delete(code);
            
            System.out.println("Roupa escluída com sucesso!!!");
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return false;
    }
    
}
