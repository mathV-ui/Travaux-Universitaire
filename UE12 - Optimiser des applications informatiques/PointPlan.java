public class PointPlan 
{
    private float abscisse ;
    
    private float ordonee ;

    public PointPlan(float x , float y )
    {
        this.abscisse=x;

        this.ordonee=y;

    }

    public void translate (float dx , float dy )
    {
        this.abscisse=this.abscisse+dx;

        this.abscisse=this.abscisse+dy;
    }
}