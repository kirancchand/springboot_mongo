package io.agileintelligence.spring_book.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import io.agileintelligence.spring_book.Model.AuthorBookModel;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;

@Repository
public class AuthorBookDALImpl implements AuthorBookDAL {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public AuthorBookModel addNewAuthor_Book(AuthorBookModel authorbook) {
		mongoTemplate.save(authorbook);
		// Now, user object will contain the ID as well
		return authorbook;
	}
	
	
//	@Override
//	public List<AuthorBookModel> getAll() {
//		return mongoTemplate.findAll(AuthorBookModel.class);
//		// Now, user object will contain the ID as well	
//	}
	
	@Override
	public AuthorBookModel getByab_id(Integer ab_id) {
	
		Query query = new Query();
		query.addCriteria(Criteria.where("ab_id").is(ab_id));
		return mongoTemplate.findOne(query, AuthorBookModel.class);
	}
	
	@Override
    public List<AuthorBookModel> getAggregagateAll() {
        // create lookup
        LookupOperation lookupAuthor = LookupOperation
                .newLookup()
                .from("authorModel")
                .localField("f_a_id")
                .foreignField("_id")
                .as("author");
        
        LookupOperation lookupBook = LookupOperation
                .newLookup()
                .from("bookModel")
                .localField("f_b_id")
                .foreignField("_id")
                .as("book");
        
        Aggregation aggregation = Aggregation
                .newAggregation(match(Criteria.where("f_a_id").gt(2)),lookupBook,lookupAuthor);

        List<AuthorBookModel> results = mongoTemplate
                .aggregate(aggregation, 
                		   "authorbookModel", 
                		   AuthorBookModel.class)
                .getMappedResults();

        return results;
    }
	

//	@Override
//	public AuthorBookModel getAggregagateAl() 
//	{
//		db.author_book_tbl.aggregate([ 
//		                              { 
//		                                  $lookup: 
//		                                  {
//		                                       from:'author_tbl', 
//		                                       localField:'f_a_id',//field of author_book_tbl
//		                                       foreignField:'author_id', //field of author_tbl
//		                                       as:'author' 
//		                                  }
//		                              },
//		                              {
//		                                  $lookup: 
//		                                  {
//		                                       from:'book_tbl', 
//		                                       localField:'f_b_id',
//		                                       foreignField:'book_id', 
//		                                       as:'book' 
//		                                  }
//		                              },
//		                              {
//		                                  $match: { "f_b_id":{ $eq : 2}  }
//		                              }
//		                           ]).toArray()
		// generates {$project: {name: $firstname}}, {$sort: {name: 1}}
//		project().and("firstname").as("name"), sort(ASC, "name")
		
//		Aggregation agg = newAggregation(
//			    project("tags"),
//			    unwind("tags"),
//			    group("tags").count().as("n"),
//			    project("n").and("tag").previousOperation(),
//			    sort(DESC, "n")
//			);
//
//			AggregationResults<TagCount> results = mongoTemplate.aggregate(agg, "tags", TagCount.class);
//			List<TagCount> tagCount = results.getMappedResults();		TagCount is a Bean Class
		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("a_id").is(a_id));
//		return mongoTemplate.findOne(query, AuthorBookModel.class);
//	}

	
//	@Override
//	public List<AuthorBookModel> getAggregagateAll() {
		// TODO Auto-generated method stub
//		LookupOperation lookup = LookupOperation.newLookup().from("AuthorModel").localField("carsrefs.f_a_id").foreignField("_id")
//				.as("cars");
//
//		AggregationResults<AuthorBookModel> result = mongoTemplate.aggregate(
//				Aggregation.newAggregation(lookup, Aggregation.match(Criteria.where("cars.color").is(Color.RED.toString()))), "people",
//				Person.class);
//
//		return result.getMappedResults();
//		
//		  AggregationOperation match = Aggregation.match(
//		            Criteria.where("dayOfWeek").is(SOME_VARIABLE_STRING_1));
//		    AggregationOperation match2 = Aggregation.match(
//		            Criteria.where("deliveryZipCodeTimings").ne(Collections.EMPTY_LIST));
		
///////////////////////		
//		   LookupOperation lookupOperation = LookupOperation
//		            .newLookup().from("AuthorModel").localField("f_a_id").foreignField("a_id").as("author");
//		   AggregationResults<AuthorBookModel> result = mongoTemplate.aggregate(
//					Aggregation.newAggregation(lookupOperation), "AuthorBookModel",AuthorBookModel.class);
////
//			return result.getMappedResults();
///////////////////////////		
		
//			return mongoTemplate.findAll(AuthorBookModel.class);
			
//		    Aggregation aggregation = Aggregation
//		            .newAggregation(lookupOperation);
//
//		    List<AuthorBookModel> results = mongoTemplate.aggregate(aggregation, "configuration", AuthorBookModel.class)
//		         .getMappedResults();
//
//		    return results;
//		return mongoTemplate.findAll(AuthorBookModel.class);
		
//////////////////////////////////////
//		LookupOperation lookupOperation = LookupOperation.newLookup().
//				from("authorModel").
//				localField("f_a_id").
//				foreignField("_id").
//				as("author");
//		Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
//		AggregationResults<AuthorBookModel> result = mongoTemplate.aggregate(aggregation, "authorbookModel", AuthorBookModel.class);
//		return result.getMappedResults();
/////////////////////////////////////////
		
//		Aggregation agg = newAggregation(
//				match(where("f_b_id").is(1))
//			);
//
//			AggregationResults<AuthorBookModel> results = mongoTemplate.aggregate(agg, "f_b_id", AuthorBookModel.class);
//			List<AuthorBookModel> authorbook = results.getMappedResults();

//	}
	

	@Override
	public List<AuthorBookModel> getAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(AuthorBookModel.class);
	}
	
	

}
