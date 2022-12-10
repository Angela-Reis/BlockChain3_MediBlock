//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2021   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package p2p.miner;

import blockchain.miner.MiningListener;

/**
 * Created on 16/11/2021, 18:01:08
 *
 * @author IPT - computer
 */
public interface RemoteMiningListenerP2P extends MiningListener {

    public void onStart(RemoteMinerP2P rm);

    public void onAddNode(IminerRemoteP2P rm);
    
    public void onException(String title, Exception ex);
    public void onMessage(String title, String message);
    
}
