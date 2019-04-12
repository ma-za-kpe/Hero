import org.junit.After;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Marvel", "saving Gotham");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void SquadInstantiatesWithName_true() throws Exception {
        Squad squad = new Squad("Marvel", "Sving gotham");
        assertEquals("Marvel", squad.getName());

    }

    @Test
    public void SquadInstantiatesWithCause_true() throws Exception {
        Squad squad = new Squad("Marvel", "Saving gotham");
        assertEquals("Saving gotham", squad.getCause());

    }

    @After
    public void tearDown() throws Exception {
        Squad.clearAllSquad(); //clear out allll the posts before each test.
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() throws Exception {
        Squad squad = new Squad("Marvel", "saving gotham");
        Squad otherSquad = new Squad ("DC", "ending gotham");
        assertEquals(2, Squad.getAllSquad().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Squad squad = new Squad("Marvel", "saving gotham");
        Squad otherSquad = new Squad ("DC", "ending gotham");
        assertTrue(Squad.getAllSquad().contains(otherSquad));
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Squad.clearAllSquad();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Squad squad = new Squad("Marvel", "saving gotham");
        assertEquals(1, squad.getId());
    }

    public Squad setupNewSquad(){
        return new Squad("Marvel", "saving Gotham");
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Squad squad = setupNewSquad();
        assertEquals(1, Squad.findById(squad.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Squad squad = setupNewSquad();
        Squad otherSquad = new Squad("Marvel", "Saving Gotham");
        assertEquals(2, Squad.findById(otherSquad.getId()).getId());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Squad squad = setupNewSquad();
        String formerName = squad.getName();
        String formerCause = squad.getCause();
        int formerId = squad.getId();

        squad.update("SCRUM", "protect crazy Gotham");

        assertEquals(formerId, squad.getId());
        assertNotEquals(formerName, squad.getName());
        assertNotEquals(formerCause,squad.getCause());
    }

    @Test
    public void deleteDeletesASpecificPost() throws Exception {
        Squad squad = setupNewSquad();
        Squad otherSquad = new Squad("Marvel" , "saave gotham");
        squad.deleteSquad();
        assertEquals(1, Squad.getAllSquad().size()); //one is left
        assertEquals(Squad.getAllSquad().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }

    @Test
    public void deleteAllPostsDeletesAllPosts() throws Exception {
        Squad squad = setupNewSquad();
        Squad otherSquad = setupNewSquad();

        Squad.clearAllSquad();
        assertEquals(0, Squad.getAllSquad().size());
    }

}