package eu.cloudscale.showcase.db.model.hibernate;

// Generated May 16, 2013 3:07:18 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import eu.cloudscale.showcase.db.model.IShoppingCart;
import eu.cloudscale.showcase.db.model.IShoppingCartLine;


/**
 * ShoppingCart generated by hbm2java
 */
@Entity
@Table( name = "shopping_cart", catalog = "tpcw" )
public class ShoppingCart implements IShoppingCart
{
	private Integer scId;

	private Date    scTime;
	
	private Set<IShoppingCartLine> shoppingCartLines = new HashSet<IShoppingCartLine>( 0 );

	public ShoppingCart()
	{
	}

	public ShoppingCart(Date scTime)
	{
		this.scTime = scTime;
	}

	@OneToMany( targetEntity=ShoppingCartLine.class, fetch = FetchType.LAZY, mappedBy = "shoppingCart" )
    public Set<IShoppingCartLine> getShoppingCartLines()
    {
    	return shoppingCartLines;
    }

    public void setShoppingCartLines(Set<IShoppingCartLine> shoppingCartLines)
    {
    	this.shoppingCartLines = shoppingCartLines;
    }

	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "SC_ID", unique = true, nullable = false )
	@Override
	public Integer getScId()
	{
		return this.scId;
	}

	@Override
	public void setScId(Integer scId)
	{
		this.scId = scId;
	}

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "SC_TIME", length = 19 )
	@Override
	public Date getScTime()
	{
		return this.scTime;
	}

	@Override
	public void setScTime(Date scTime)
	{
		this.scTime = scTime;
	}

}
