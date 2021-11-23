package view.paneler.centerPanel;

import java.awt.Label;
import javax.swing.*;

import fonts.Fonts;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	Label statusLabel = new Label("statusLabel");
	TerningPanel terningPanel = new TerningPanel();
	HoldKnappPanel holdKnappPanel = new HoldKnappPanel();
	
	public CenterPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		statusLabel.setFont(Fonts.getStatusFontFont());
		add(statusLabel);
		add(terningPanel);
		add(holdKnappPanel);
	}

	public Label getStatusLabel() {
		return statusLabel;
	}

	public TerningPanel getTerningPanel() {
		return terningPanel;
	}

	public HoldKnappPanel getHoldKnappPanel() {
		return holdKnappPanel;
	}
}
