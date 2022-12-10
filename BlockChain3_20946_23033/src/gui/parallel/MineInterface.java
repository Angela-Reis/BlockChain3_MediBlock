/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.parallel;

/**
 *
 * @author AR
 */
public interface MineInterface {
    //when starts mining
    public void onStart();
    //during mining
    public void onUpdate(int nonce);
    //when it stops mining
    public void onFinish(int nonce);
}
