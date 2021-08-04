package com.lti.daos;

import java.util.List;

import com.lti.models.Offer;

public interface OfferDao {
	public abstract Offer getOfferByID(int id);
	public abstract List<Offer> getOfferes();
	public abstract List<Offer> getOffersItems();
	public abstract int addOffer(Offer offer);
	public abstract boolean updateOffer(Offer offer);
	public abstract int deleteOffer(int id);
	public abstract int deleteOfferByItem(int id);
	public abstract Offer getOfferByItem(int item_id);
	public abstract Offer getOfferByCustomer(int cus_id);
}
