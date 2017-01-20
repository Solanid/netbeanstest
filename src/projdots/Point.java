/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projdots;

import enumeration.Quadrant;
import java.util.Random;

/**
 *
 * @author Solanid
 */
public class Point {
    private double x;
    private double y;
    private char name;
    
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
    
    public Quadrant getQuadrant() {
        if(x>0 && y>0)
            return Quadrant.I;
        else if(x<0 && y>0)
            return Quadrant.II;
        else if(x<0 && y<0)
            return Quadrant.III;
        else if(x>0 && y<0)
            return Quadrant.IV;
        else 
            return Quadrant.none;
    }
    
    public double getDistance() {
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }
    
    public Point(double x, double y) {
        this.name = 'a';
        this.x = x;
        this.y = y;
    }
    
    public Point() {
        this.name = 'a';
        x=y=0;
    }
    
    public Point(double x) {
        this.name = 'a';
        this.x = this.y = x;
    }
    
    public Point(Point otherPoint) {
        this.x=otherPoint.getX();
        this.y=otherPoint.getY();
        this.name=otherPoint.getName();
    }
    
    public double getDistanceFromOtherPoint(Point otherPoint) {
        return Math.sqrt(Math.pow(x - otherPoint.getX(), 2)+Math.pow(y - otherPoint.getY(), 2));
    }
    
    public void randomPosition() {
        Random rnd = new Random();
        x=rnd.nextInt(41)-20+rnd.nextDouble();
        y=rnd.nextInt(41)-20+rnd.nextDouble();
    }
    
    @Override
    public String toString(){
       return "Name:"+name+"[ "+x+", "+y+" ]"; 
    }
    
    public boolean isInSameQuadrant(Point otherPoint) {
        return this.getQuadrant()==otherPoint.getQuadrant() && this.getQuadrant()!=Quadrant.none;
    } 
    
    public void moveToCentralSymmetry() {
        x*=-1;
        y*=-1;
    }
    
    public void lineSymetry(char axis) {
        switch(axis) {
            case 'y':
            case 'Y': x *= -1; break;
            case 'x':
            case 'X': y *= -1; break;
            default: System.out.println("Incorrect parameter axis!");
        }
    }
    
    public Point clonePoint() {
        Point newPoint = new Point(this.x, this.y);
        newPoint.setName(this.name);
        return newPoint;
    }
    
}
