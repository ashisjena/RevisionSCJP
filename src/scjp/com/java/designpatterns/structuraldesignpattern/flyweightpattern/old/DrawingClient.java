package scjp.com.java.designpatterns.structuraldesignpattern.flyweightpattern.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import scjp.com.java.designpatterns.structuraldesignpattern.flyweightpattern.old.ShapeFactory.ShapeType;

/*
    This pattern is used to reduce the memory footprint. It can also improve performance in applications where object instantiation is expensive.
    Simply put, the flyweight pattern is based on a factory which recycles created objects by storing them after creation.
    Each time an object is requested, the factory looks up the object in order to check if it's already been created.
    If it has, the existing object is returned – otherwise, a new one is created, stored and then returned.
    Fly Weight objects are immutable. Any operation on the state must be performed by the factory.
 */
public class DrawingClient extends JFrame
{
    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeType shapes[] = { ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NOFILL };
    private static final Color colors[] = { Color.RED, Color.GREEN, Color.YELLOW };

    public DrawingClient( int width, int height )
    {
        this.WIDTH = width;
        this.HEIGHT = height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton( "Draw" );
        final JPanel panel = new JPanel();

        contentPane.add( panel, BorderLayout.CENTER );
        contentPane.add( startButton, BorderLayout.SOUTH );
        setSize( WIDTH, HEIGHT );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );

        startButton.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent event )
            {
                Graphics g = panel.getGraphics();
                for ( int i = 0; i < 20; ++i )
                {
                    Shape shape = ShapeFactory.getShape( getRandomShape() );
                    shape.draw( g, getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight(), getRandomColor() );
                }
            }
        } );
    }

    private ShapeType getRandomShape()
    {
        return shapes[ (int)( Math.random() * shapes.length ) ];
    }

    private int getRandomX()
    {
        return (int)( Math.random() * WIDTH );
    }

    private int getRandomY()
    {
        return (int)( Math.random() * HEIGHT );
    }

    private int getRandomWidth()
    {
        return (int)( Math.random() * ( WIDTH / 10 ) );
    }

    private int getRandomHeight()
    {
        return (int)( Math.random() * ( HEIGHT / 10 ) );
    }

    private Color getRandomColor()
    {
        return colors[ (int)( Math.random() * colors.length ) ];
    }

    public static void main( String[] args )
    {
        DrawingClient drawing = new DrawingClient( 500, 600 );
    }
}