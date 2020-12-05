/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica.abstrata.botoes;

/**
 *
 * @author Joao
 */
public class FabricaBotoesIcones extends FabricaAbstrataBotoes{
    private ButtonOK ok;
    private ButtonCancel cancel;
    
    
    public ButtonCancel criaBotaoCancel(){
            cancel = new ButtonCancel();
            cancel.setText("Cancel");
    
        return cancel;
    };
    public ButtonOK criaBotaoOK(){
    
            ok = new ButtonOK();
            ok.setText("OK");
            
            return ok;
    };
    
    
    
    
    
}
