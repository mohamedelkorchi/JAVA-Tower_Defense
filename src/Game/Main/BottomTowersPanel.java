package Game.Main;

import Game.Entities.Towers.Tower;
import Game.Entities.Towers.TowerType.Air;
import Game.Entities.Towers.TowerType.Melee;
import Game.Entities.Towers.TowerType.Range;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomTowersPanel extends JPanel {

  public static Tower.Type selectedType;

  public BottomTowersPanel(Game game, PlayPage playPage) {
    setBackground(Color.RED);
    setPreferredSize(new Dimension(500, 140));
    setLayout(new FlowLayout());

    ImageIcon basicImage = new ImageIcon(Range.getImage());
    JButton range = new JButton(basicImage);
    range.addActionListener(e -> selectedType = Tower.Type.RANGE);
    ImageIcon canonImage = new ImageIcon(Melee.getImage());
    JButton melee = new JButton(canonImage);
    melee.addActionListener(e -> selectedType = Tower.Type.MELEE);
    ImageIcon chikwangueImage = new ImageIcon(Air.getImage());
    JButton air = new JButton(chikwangueImage);
    air.addActionListener(e -> selectedType = Tower.Type.AIR);

    add(range);
    add(melee);
    add(air);
  }
}
