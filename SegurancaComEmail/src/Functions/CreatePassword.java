/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author guilh
 */
public class CreatePassword {
    
    private String senha;

    public String getSenha() {
        return gerarSenha();
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String gerarSenha(){
        
        int qtdCar = 6;
        
        String[] caracteres = {
            "a", "1", "b", "2", "3", "4", "5", "6", "7", "8",
            "9","b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z" 
        };
        
        StringBuilder senhaBuilder = new StringBuilder();
        
        for (int i=0; i<qtdCar; i++){
            int posicao = (int) (Math.random() * caracteres.length);
            senhaBuilder.append(caracteres[posicao]);
        }
        
        String arrayToString = String.join(" - ", senhaBuilder);
        
        setSenha(arrayToString);
        
        return senhaBuilder.toString();
        
    }
    
}
