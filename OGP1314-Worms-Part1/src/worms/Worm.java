/**
 * 
 */
package worms;
import worms.util.*;
import be.kuleuven.cs.som.annotate.Model;
import be.kuleuven.cs.som.annotate.Basic;

/**
 * @author Pieter Kusters
 * @author Thibaut Bender
 * @version 1.0
 * 
 */

//oezfjdeiozjafikeopfk
public class Worm {


/**
 * This is the variable that gives the horizontal position of the worm on the x-axis.
 */
private double positionX;
/**
 * This is the variable that gives the vertical position of the worm on the y-axis.
 */
private double positionY;
/**
 * Here the Number of action points was stored as integer variable. The action points can be used to move, jump or turn.
 */
private int actionPoint;
/**
 * This indicates the minimal radius a worm should have when he is created.
 */
private final double minRadius=0.25;
/**
 * This is the density a worm has, this is final and static because it is the same for all the worms and can't change during the game.
 */
private static final double Density = 1062.0;
/**
 * This is the Gravity a worm has, this is final and static because it is the same for all the worms and can't change during the game.
 */
private static final double Gravity = 9.80665;
/**
 * Variable where the name is stored.
 */
private String name;
/**
 * The worm is shaped as a circle, this circle is defined by this value, it must be greater than the minRadius.  
 */
private double radius;
/**
 * This gives the angle in radians in witch way the worm  is facing to,
 * the angle is defined as 0 for facing at the right, pi/2 facing the vertical axis and pi for facing to the left. 
 */
private double angle;

/**
 * Creates the worm with some initialization parameters.
 * @param Px
 * 			this gives the initial position on the horizontal axis of the worm
 * @param Py
 * 			this gives the initial position on the vertical axis of the worm
 * @param angle
 * 			this gives the starting angle the worm is facing at in radians, facing the positive x-axis at 0, the negative x-axis at pi and the positive y-axis on pi/2. 
 * @param radius
 * 			gives the value of the shape of the worm 
 * @param name 
 * 			the name of the worm

 * @pre The orientation is valid.
 * 		/ValidAngle(angle)
 * @effect The X coordinate is set to the given value.
 * 		/new.getX() == Px
 * @effect The X coordinate is set to the given value.
 * 		/new.getY() == Py
 * @effect The radius of the worm is set the value given.
 * 		/new.getRadius() == radius
 * @effect The name of the worm is equal to the given string if the name is valid.
 * 		/new.getName() == name
 * @effect The number of action points is set to the maximum number of action points a worm can have, 
 * 			this is done with the method getMaxPossiblePoints. 
 * 		/new.getActionPoints() ==this.getMaxPossiblePoints
 * @throws IllegalArgumentExeption if the name is not allowed.
 * 		/!ValidName(name)
 * @throws IllegalArgumentExeption if the X or Y coordinate is not valid, this is done by the method validX or validY.
 * 		/validX(X)   validY(Y)
 * @throws  Illegal argument als radius of angle niet valid is?
 */
public Worm(double Px, double Py,double angle, double radius, String name) throws IllegalArgumentException {

		this.setPositionX(Px);
		this.setPositionY(Py);
		this.setRadius(radius);
		this.setNaming(name);
		this.setActionPoints(this.getMaxPossiblePoints());
		this.setOrientation(angle);

}


/**
 * basic inspector that returns the radius of the worm.
 * @return the minimal radius that the worm should have
 */
@Basic
public double getMinRadius() {
	return this.minRadius;
}


/**
 * The horizontal position of the worm is set.
 * @param X the x-coordinate of the worm
 * @post the new x-coordinate for this worm is set to the given x-coordinate.
 * 		/new.getX()==x
 * @throws IllegalArgumentException
 * 			If the given x-coordinate is not valid
 * 		/!validX
 */
public void setPositionX(double X) throws IllegalArgumentException {
	if (validX(X)){
	this.positionX=X;}
	else throw new IllegalArgumentException();
}


/**
 * Looks if the horizontal coordinate is valid.
 * @param x the x-coordinate of the worm
 * @return looks if the given parameter is of the type double if it is it returns true
 */
public boolean validX(double x) {
	return (!Double.isNaN(x));
}


/**
 * Gives the horizontal position of the worm.
 * @return gives the location of the worm on the X-axis
 */
@Basic
public double getPositionX(){
	return this.positionX;
}


/**
 * The vertical position of the worm is set.
 * @param Y the y-coordinate of the worm
 * @post the new y-coordiinate for this worm is set tot the given x-coordinate.
 * 		/new.getY()==y
 * @throws IllegalArgumetnExeption
 * 				if the fiven y-coordinate is not valid
 * 		/!validY
 */
public void setPositionY(double Y){
	if (validY(Y)){
	this.positionY=Y;}
	else throw new IllegalArgumentException();
}


/**
 *  Looks if the vertical coordinate is valid.
 * @param y the y-coordinate of the worm
 * @return looks if the given parameter is of the type double if it is it returns true
 */
public boolean validY(double y) {
	return (!Double.isNaN(y));
}


/**
 * gives the vertical position of the worm.
 * @return gives the location of the worm on the y-axis
 */
@Basic
public double getPositionY(){
	return this.positionY;
}


/**
 * set the number of action points a worm has, it looks first of all that the norm of action points it gets is bigger than 0,
 * Afterwards it looks that the given parameter isn't bigger than the max possible action points and if so it allocates the maximum possible action points to the variable
 *		/new.getMaxPossiblePoints() = Math.round(getMass())
 * of neither of the 2 statements were true the number of action points was set to the parameter value actionPoints.
 * @param actionPoints this is the number of action points the worm has.
 * 	/new.getActionPoints() == actionPoints
 * @post the variable ActionPoint is given a value= the action points a worm can spend.
 */
public void setActionPoints(int actionPoints){   

	if (actionPoints <0) {
		this.actionPoint =0;}

	else if (actionPoints > getMaxPossiblePoints()){
		this.actionPoint = getMaxPossiblePoints();}	

	else { this.actionPoint = actionPoints ; }		
}	

/**
 * gives the number of action points left for the worm.
 * @return the number of action points left for the worm
 */
@Basic
public int getActionPoint() {
	return this.actionPoint ;	
}
/**
 * calculates and gives the maximum number of action points a worm can have.
 * @return the maximum number of action points this is equal to the worms mass rounded to the nearest integer.
 * 		/result == (int) Math.round(getMass());
 * 
 */
@Basic
public int getMaxPossiblePoints() {
	return (int) Math.round(getMass());
	// check if it is not bigger then 32 bits
}
/**
 *  calculates the mass of the worm based on the radius of the worm
 * @return the mass of the worm, the mass is based on the radius of the worm and the density all worms has.
 * 		/ Worm.Density*((4.0/3.0)*Math.PI*Math.pow(this.getRadius(),3))
 */
@Basic
public double getMass(){

		return  Worm.Density*((4.0/3.0)*Math.PI*Math.pow(this.getRadius(),3));
}
/**
 * gives the worm the radius given by the parameter
 * @param givenradius the new radius of this worm
 * @post the new radius of the worm is equal to the value of the parameter
 * 		/new.getRadius() == radius
 * @throws IllegalArgumentException
 * 				the given radius is not valid
 */
public void setRadius(double givenradius) throws IllegalArgumentException {
	if (validRadius(givenradius)) {
		this.radius= givenradius;
	}
	else throw new IllegalArgumentException("Illegal value for the radius");
}
/**
 * checks if the radius of the worm is a valid radius
 * @param radius the radius witch need to be checked if it is valid or not.
 * @return True if the radius is bigger than the minimal radius or 
 * 			false if the radius is lower than the minimal radius a worm should need to have.
 * 		/radius>minRadius
 */

public boolean validRadius(double radius){
	if (radius>minRadius) {return true;}
	else {return false;}
}
/**
 * the radius of the worm
 * @return the radius of this worm
 */
@Basic
public double getRadius() {
	return radius;
}


/**
 * Set the name of the worm.
 * @param GivenName
 * 		 
 *
 * @throws IllegalArgumentException
 * 		   The given name has to be valid.
 *           | ValidName(GivenName) == FALSE;
 *         
 * @post  The name of the worm is equal to the given name.
 *			 | new.getName() == GivenName;
 * 
 */
public void setNaming(String GivenName) throws IllegalArgumentException {
		if (ValidName(GivenName))
			{this.name=GivenName;}

		else 
			throw new IllegalArgumentException("This isn't a valid name.");	
}



/**
 * Check whether the name for the worm is valid.
 * @param name
 * 		  The name for the worm that has to be checked
 * 
 * @return TRUE if the name is valid, False if the name is not valid.
 * 		 
 */
@Model
public boolean ValidName(String name) {

	if (name.length() < 2)
		{return false ;}
	else if (!Character.isUpperCase(name.charAt(0)))
		{return false ;}

	else if (name.matches("[a-zA-Z'\" ]*"))
		{return true ;}
	else
	{ return false;  }
}

/**
 * Get the name of the worm.
 * @return the name of the worm.
 */
@Basic
public String getNaming() {
	return name; 
}


/**
 * Change the name of the worm.
 * @param newName
 * 		     The new name for the worm.
 * @post The new name of the worm is equal to the given name for the worm, if the name is valit. 
 * 		 	|new.getName() == newName && this.ValidName(String name) == true;	
 */
public void changeNaming(String newName) {
	this.setNaming(newName);
}


/**
 * Gives the worm a orientation (the direction where he is looking at).
 * @param angle the new angle that is given to the worm
 * @pre looks if the angle has a valid direction
 * 		/ValidAngle(angle)
 * @post the new orientation of this worm is set to the given angle
 */
public void setOrientation(double angle){
	assert ValidAngle(angle);
	this.angle=angle;
}


/**
 * Looks if the angle is between -2.0PI and 2.0PI.
 * @param angle the angle to look if it is located in the given domain
 * @return true if the angle is in the given range 
 * 			false if it is out of the bound
 * 		/-2.0*Math.PI<= angle <=2.0*Math.PI
 */
public boolean ValidAngle(double angle) {
	if (angle>=-2.0*Math.PI && angle<=2.0*Math.PI){
	return true;}
	else return false;
}


/**
 * The current orientation of the worm.
 * @return the current angle the worm is looking at
 */
@Basic
public double getOrientation() {
	return angle;
}


/**
 * Looks if the turn is possible.
 * @param angle the angle where the worm is moving to
 * @return true if there are enough action points left to perform this operation
 * 			false if there aren't enough action points left
 * 			/Math.abs(Math.ceil(angle*(60/2*Math.PI)))<=this.getActionPoint()
 */
public boolean TurnPossible(double angle){
	int costTurn = (int) Math.abs(Math.ceil(60/(angle/2*Math.PI)));
	return costTurn <= this.getActionPoint();
}


/**
 * Changes the direction of the worm.
 * @param angle the angle where it is opposed to turn to
 * @pre checks if the angle is valid
 * 		/ValidAngle(angle)
 * @pre checks if the angle where the worm is facing to is valid
 * 		/ValidAngle(this.getOrientation() + angle)
 * @pre looks if the Turn is possible so there are enough action points left
 * 		/TurnPossible(angle)
 * @effect the orientation of the worm is changed to the new angle 
 * 		/this.setOrientation(this.getOrientation()+ angle)
 * @effect the action points are reduced 
 * 		/this.setActionPoints(this.getActionPoint()-Math.abs(costTurn))
 */
public void turn(double angle){
	assert this.ValidAngle(angle);
	assert this.ValidAngle(this.getOrientation() + angle); // weglaten of niet test bij setOrientation of is het een voorwaarde om Turn uit te voeren?
	assert this.TurnPossible(angle);
	int costTurn = (int) Math.ceil((Math.abs(angle)-this.getOrientation())*(60/(2*Math.PI)));
	this.setActionPoints(this.getActionPoint()-Math.abs(costTurn)); 
	this.setOrientation(this.getOrientation()+ angle);

}


/**
 * Moves the worm with a given number of steps in the current orientation of the worm.
 * @param nbSteps the number of steps the worm should move
 * @post the position of the worm is changed based on the radius of the worm and the current position.
 * 		/travelled= nbSteps*this.radius
 * 		/this.setPositionX(this.getPositionX()+travelled*Math.cos(this.getOrientation()))
 * 		/this.setPositionY(this.getPositionY()+travelled*Math.sin(this.getOrientation()))
 * @throws IllegalArgumentException if there are to much steps so that there aren't enough action points.
 * 			/movePossible(nbSteps)
 * @effect the action points are reduced with the cost of the move
 * 			/this.setActionPoints(this.getActionPoint() - costMove(nbSteps))
 */
public void Move(int nbSteps) throws IllegalArgumentException  {
	if (movePossible(nbSteps)){ 
		this.setActionPoints(this.getActionPoint() - costMove(nbSteps));
		double travelled= nbSteps*this.radius;
		this.setPositionX(this.getPositionX()+travelled*Math.cos(this.getOrientation()));
		this.setPositionY(this.getPositionY()+travelled*Math.sin(this.getOrientation()));
		}
	else throw new IllegalArgumentException("you don't have enough action points.");
}


/**
 * Calculates the cost of a move.
 * @param nbSteps the number of steps a worm would like to move
 * @return the total cost of the move in a given direction
 * 			/ costMove = (int)Math.abs(Math.ceil(nbSteps*((double)Math.abs(Math.cos(this.getOrientation())))+ (double)Math.abs(4*Math.sin(this.getOrientation()))))
 */
public int costMove (int nbSteps) {
	int costMove = (int)Math.abs(Math.ceil(nbSteps*((double)Math.abs(Math.cos(this.getOrientation())))+ (double)Math.abs(4*Math.sin(this.getOrientation()))));
	return costMove ;
}


/**
 * Looks if there are enough action points left to perform the move.
 * @param nbSteps the number of steps the worm would like to move
 * @return true if there are enough action points left
 * 			false if there aren't enough action points left
 * 				/costMove(nbSteps) <= this.getActionPoint()
 */
public boolean movePossible(int nbSteps){
	return costMove(nbSteps) <= this.getActionPoint();
}



/**
 * make a worm jump along ballistic trajectories.
 * 
 * @throws IllegalArgumentException
 *     
 *     The worm has to have more the 0 action points.
 *			 | this.CheckActionPoints() == FALSE;
 *     
 *     The worm's orientation has to be in the range ( 0 < orientation < PI )
 *           | this.CheckOrientation() == FALSE;
 * 	   
 * @effect The new position of the worm as a result of a jump is equal to position described in this.getJumpStep(double t) .
 * 			// | this.getJumpStep(double t);7
 * 		 The action points are set to 0 . 
 *  		 | this.setActionPoints(0);
 */
public void Jump() throws IllegalArgumentException {
	if(this.CheckActionPoints()){
			if(this.CheckOrientation()){
				double t=this.getJumpTime();
				double[] endPosition = this.getJumpStep(t);
				this.setPositionX(endPosition[0]);
				this.setPositionY(endPosition[1]);
				this.setActionPoints(0);
			}
			else { throw new IllegalArgumentException("this is not a valid jump, the worm has to be facing up.");}
	}
	else {throw new IllegalArgumentException ("You dont have enough action points to jump.");}
	}


/**
 * Check if the worm has enough action points to make a jump.
 * @return TRUE if the worm has more then 0 action points, FALSE if the worm has 0 action points.
 */
public boolean CheckActionPoints() {
	return this.getActionPoint() > 0 ;
}


/**
 * Check if the worm is facing up to make a jump. 
 * @return TRUE if the worm's orientation is in the range ( 0 < orientation < PI ) 
 */
public boolean CheckOrientation() {
	return Util.fuzzyGreaterThanOrEqualTo(this.getOrientation(),0) && (!Util.fuzzyGreaterThanOrEqualTo(this.getOrientation(),Math.PI));
}


/**
 * Get the time to make a jump.
 * @return the time in seconds for a potential jump from the current position.
 */
//formal doc
public double getJumpTime(){
	double distance= ((Math.pow(this.getIntialVelocity(),2))*(Math.sin(2*this.getOrientation())))/Worm.Gravity;
	double t= distance/(this.getIntialVelocity()*Math.cos(this.getOrientation()));
	return t;
}
// divided by 0 pi/2


/**
 * Computes the on-flight position [x,y] of a jumping worm at any seconds afther launch.
 * @param t
 * 		the time in seconds for a potential jump from the current position.
 * @return
 * 		the end position of the worm afther a jump.
 */
//formal doc
public double[] getJumpStep(double t){  
	double velocityX=(this.getIntialVelocity()*Math.cos(this.getOrientation()));
	double velocityY=(this.getIntialVelocity()*Math.sin(this.getOrientation()));
	double positionAftherJumpX= (getPositionX() + (velocityX*t));
	double positionAftherJumpY= (getPositionY() + ((velocityY*t) - 0.5*(Worm.Gravity*Math.pow(t,2))));
	double[] endPosition = {positionAftherJumpX,positionAftherJumpY};
	return endPosition;	
}


/**
 * Looks what is the initial velocity of the worm.
 * @return the initial velocity of the worm in current conditions
 * 			/F= (5*this.getActionPoint())+(this.getMass()*Worm.Gravity)
 * 			/V0= ((F/this.getMass())*0.5)
 */
public double getIntialVelocity() {
	double F= (5*this.getActionPoint())+(this.getMass()*Worm.Gravity);
	double V0= ((F/this.getMass())*0.5);
	return V0;		
}


}
