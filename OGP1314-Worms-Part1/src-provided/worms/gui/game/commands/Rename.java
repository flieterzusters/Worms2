package worms.gui.game.commands;

import worms.IFacade;
import worms.Worm;
import worms.gui.game.PlayGameScreen;
import worms.model.ModelException;

public class Rename extends InstantaneousCommand {
	private final String newName;
	private final Worm worm;

	public Rename(IFacade facade, Worm worm, String newName,
			PlayGameScreen screen) {
		super(facade, screen);
		this.worm = worm;
		this.newName = newName;
	}

	@Override
	protected boolean canExecute() {
		return worm != null;
	}

	@Override
	protected void doStartExecution() {
		try {
			getFacade().rename(worm, newName);
		} catch (ModelException e) {
			// an invalid name
			getScreen().addMessage("Invalid name: " + newName);
		}
	}
}