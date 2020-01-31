/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter.Interface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class MediaPlayer {
    
    private final JFrame frame = new JFrame("Media Center");
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private final JButton pauseButton = new JButton("Pause");
    private final JButton rewindButton = new JButton("Rewind");
    private final JButton skipButton = new JButton("Skip");
    private String caminho;
    
    public MediaPlayer(String caminho1) throws IOException{
        caminho = caminho1;
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
 
        // Adicionar componentes 
        controlsPane.add(pauseButton);
        controlsPane.add(rewindButton);    
        controlsPane.add(skipButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().pause();
            }
        });

        rewindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipTime(1000);
            }
        });

       
        frame.setContentPane(contentPane);
        frame.setVisible(true);
      
 
        mediaPlayerComponent.mediaPlayer().media().play(caminho);
    }
    
    

    
}
