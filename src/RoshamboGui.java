import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class RoshamboGui extends JFrame {

    public RoshamboGui() throws IOException {
        super("Roshambo");
        setSize(450,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        File logofile = new File("assets\\logo.png");
        Image logo = ImageIO.read(logofile);

        setIconImage(logo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addElements();

    }

    private void addElements() throws IOException {
        AtomicInteger cmpscore = new AtomicInteger(0);
        AtomicInteger playerscore = new AtomicInteger(0);
        JLabel computerScoreLabel = new JLabel("Computer Score: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        JLabel playerScoreLabel = new JLabel("Player Score: 0");
        playerScoreLabel.setBounds(0, 83, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        JLabel computerChoice = new JLabel(loadimage("assets\\barrier.png"));
        computerChoice.setBounds(0, 198, 450, 200);
        computerChoice.setFont(new Font("Dialog", Font.BOLD, 26));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(computerChoice);

        JButton playeroption1 = new JButton(loadimage("assets\\rock.png"));
        playeroption1.setBounds(30, 500, 100, 100);
        playeroption1.setFont(new Font("Dialog", Font.BOLD, 26));
        //playeroption1.setHorizontalAlignment(SwingConstants.CENTER);
        playeroption1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(playeroption1);
        JLabel winner = new JLabel();
        playeroption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                remove(winner);
                int cmpchoice = (int) Math.floor(Math.random() * 3) + 1;
                if (cmpchoice == 1) {
                    try {
                        computerChoice.setIcon(loadimage("assets\\rock.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (cmpchoice == 2) {
                    try {
                        computerChoice.setIcon(loadimage("assets\\paper.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        computerChoice.setIcon(loadimage("assets\\scissor.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                switch (cmpchoice) {
                    case 2:
                        remove(winner);
                        winner.setText("Computer Wins");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);
                        cmpscore.set(cmpscore.get() + 1);
                        playerScoreLabel.setText("Player Score: "+ playerscore.get());
                        computerScoreLabel.setText("Computer Score: "+cmpscore.get());
                        break;
                    case 3:
                        remove(winner);
                        winner.setText("Player Wins");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);

                        playerscore.set(playerscore.get() + 1);
                        playerScoreLabel.setText("Player Score: "+ playerscore.get());
                        computerScoreLabel.setText("Computer Score: " + cmpscore.get());
                        break;
                    case 1:
                        remove(winner);
                        winner.setText("Draw");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);

                        playerScoreLabel.setText("Player Score: " + playerscore.get());
                        computerScoreLabel.setText("Computer Score: " + cmpscore.get());
                        break;
                }
            }
        });


        JButton playeroption2 = new JButton(loadimage("assets\\paper.png"));
        playeroption2.setBounds(160, 500, 100, 100);
        playeroption2.setFont(new Font("Dialog", Font.BOLD, 26));
        //playeroption1.setHorizontalAlignment(SwingConstants.CENTER);
        playeroption2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        playeroption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                remove(winner);
                int cmpchoice = (int) Math.floor(Math.random() * 3) + 1;
                if (cmpchoice == 1) {
                    try {
                        computerChoice.setIcon(loadimage("assets\\rock.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (cmpchoice == 2) {
                    try {
                        computerChoice.setIcon(loadimage("assets\\paper.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        computerChoice.setIcon(loadimage("assets\\scissor.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                switch (cmpchoice) {
                    case 2:
                        remove(winner);
                        winner.setText("Draw");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);
                        playerScoreLabel.setText("Player Score: "+ playerscore.get());
                        computerScoreLabel.setText("Computer Score: "+cmpscore.get());
                        break;
                    case 3:
                        remove(winner);
                        winner.setText("Computer Wins");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);

                        cmpscore.set(cmpscore.get() + 1);
                        playerScoreLabel.setText("Player Score: "+ playerscore.get());
                        computerScoreLabel.setText("Computer Score: " + cmpscore.get());
                        break;
                    case 1:
                        remove(winner);
                        winner.setText("Player Wins");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);
                        playerscore.set(playerscore.get() + 1);
                        playerScoreLabel.setText("Player Score: " + playerscore.get());
                        computerScoreLabel.setText("Computer Score: " + cmpscore.get());
                        break;
                }
            }
        });

        add(playeroption2);

        JButton playeroption3 = new JButton(loadimage("assets\\scissor.png"));
        playeroption3.setBounds(290, 500, 100, 100);
        playeroption3.setFont(new Font("Dialog", Font.BOLD, 26));
        //playeroption1.setHorizontalAlignment(SwingConstants.CENTER);
        playeroption3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        playeroption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                remove(winner);
                int cmpchoice = (int) Math.floor(Math.random() * 3) + 1;
                if (cmpchoice == 1) {
                    try {
                        computerChoice.setIcon(loadimage("assets\\rock.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (cmpchoice == 2) {
                    try {
                        computerChoice.setIcon(loadimage("assets\\paper.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        computerChoice.setIcon(loadimage("assets\\scissor.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                switch (cmpchoice) {
                    case 2:
                        remove(winner);
                        winner.setText("Player Wins");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);
                        playerscore.set(playerscore.get() + 1);
                        playerScoreLabel.setText("Player Score: "+ playerscore.get());
                        computerScoreLabel.setText("Computer Score: "+cmpscore.get());
                        break;
                    case 3:
                        remove(winner);
                        winner.setText("Draw");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);

                        playerScoreLabel.setText("Player Score: "+ playerscore.get());
                        computerScoreLabel.setText("Computer Score: " + cmpscore.get());
                        break;
                    case 1:
                        remove(winner);
                        winner.setText("Computer Wins");
                        winner.setBounds(0, 200, 450, 30);
                        winner.setFont(new Font("Dialog", Font.BOLD, 26));
                        winner.setHorizontalAlignment(SwingConstants.CENTER);
                        add(winner);
                        cmpscore.set(cmpscore.get() + 1);
                        playerScoreLabel.setText("Player Score: " + playerscore.get());
                        computerScoreLabel.setText("Computer Score: " + cmpscore.get());
                        break;
                }
            }
        });

        add(playeroption3);
    }
    private Icon loadimage(String path) throws IOException {
        File file = new File(path);
        Image image = ImageIO.read(file);
        return new ImageIcon(image);
    }
}
