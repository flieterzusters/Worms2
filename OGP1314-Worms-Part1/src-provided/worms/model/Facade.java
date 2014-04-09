package worms.model;

import worms.IFacade;
import worms.Worm;



public class Facade implements IFacade {

	@Override
	public Worm createWorm(double x, double y, double direction, double radius,
			String name) throws IllegalArgumentException{

		try {Worm wormpie = new Worm(x,y,direction,radius,name);
			return wormpie;}
		catch(IllegalArgumentException illegalargument) {
			throw new ModelException(illegalargument);
		}
	}

	@Override
	public boolean canMove(Worm worm, int nbSteps) {
		return worm.movePossible(nbSteps);
	}


	@Override
	public void move(Worm worm, int nbSteps) throws IllegalArgumentException {
		try { worm.Move(nbSteps);}    
		catch(IllegalArgumentException illegalargument)	{
			throw new ModelException(illegalargument);
		}
	}

	@Override
	public boolean canTurn(Worm worm, double angle) {
		return worm.TurnPossible(angle);
	}

	@Override
	public void turn(Worm worm, double angle) {
		worm.turn(angle);
	}

	@Override
	public void jump(Worm worm)throws IllegalArgumentException {
		try {worm.Jump();}
		catch(IllegalArgumentException illegalargument)	{
				throw new ModelException(illegalargument);
				}
	}

	@Override
	public double getJumpTime(Worm worm) {
		return worm.getJumpTime();
	}

	@Override
	public double[] getJumpStep(Worm worm, double t) {
		return worm.getJumpStep(t);
	}

	@Override
	public double getX(Worm worm) {
		return worm.getPositionX();
	}

	@Override
	public double getY(Worm worm) {
		// TODO Auto-generated method stub
		return worm.getPositionY();
	}

	@Override
	public double getOrientation(Worm worm) {
		// TODO Auto-generated method stub
		return worm.getOrientation();
	}

	@Override
	public double getRadius(Worm worm) {
		return worm.getRadius();
	}

	@Override
	public void setRadius(Worm worm, double newRadius) {
		try{worm.setRadius(newRadius);}
		catch(IllegalArgumentException illegalargument){
			throw new ModelException(illegalargument);
		}
	}

	@Override
	public double getMinimalRadius(Worm worm) {
		return worm.getMinRadius();
	}

	@Override
	public int getActionPoints(Worm worm) {
		return worm.getActionPoint();
	}

	@Override
	public int getMaxActionPoints(Worm worm) {
		return worm.getMaxPossiblePoints();
	}

	@Override
	public String getName(Worm worm) {
		return worm.getNaming();
	}

	@Override
	public void rename(Worm worm, String newName) {
	   worm.changeNaming(newName); 

	}

	@Override
	public double getMass(Worm worm) {
		return worm.getMass();
	}

}