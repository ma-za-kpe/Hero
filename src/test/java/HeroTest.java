import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero post = new Hero("Iron Man", "flying", "water", 23);
        assertEquals(true, post instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero post = new Hero("Iron Man", "flying", "water", 23);
        assertEquals("Iron Man", post.getName());

    }

    @Test
    public void HeroInstantiatesWithspecialSkill_true() throws Exception {
        Hero post = new Hero("Iron Man", "flying", "water", 23);
        assertEquals("flying", post.getSpecialSkill());

    }

    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception {
        Hero post = new Hero("Iron Man", "flying", "water", 23);
        assertEquals("water", post.getWeakness());

    }

    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
        Hero post = new Hero("Iron Man", "flying", "water", 23);
        assertEquals(23, post.getAge());

    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHeroes(); //clear out allll the posts before each test.
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() throws Exception {
        Hero hero = new Hero("Iron Man", "flying", "water", 23);
        Hero otherHero = new Hero ("Spiderman", "flying", "water", 23);
        assertEquals(2, Hero.getAllHeroes().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Hero hero = new Hero("Iron Man", "flying", "water", 23);
        Hero otherHero = new Hero ("Spiderman", "flying", "water", 23);
        assertTrue(Hero.getAllHeroes().contains(hero));
        assertTrue(Hero.getAllHeroes().contains(otherHero));
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Hero.clearAllHeroes();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Hero myPost = new Hero("Iron Man", "flying", "water", 23);
        assertEquals(1, myPost.getId());
    }

    public Hero setupNewPost(){
        return new Hero("Iron Man", "flying", "water", 23);
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Hero post = setupNewPost();
        assertEquals(1, Hero.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Hero hero = setupNewPost();
        Hero otherHero = new Hero("Spiderman", "flying", "water", 23);
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }

}