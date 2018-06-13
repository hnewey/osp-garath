package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.model.character.ClassType;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import org.junit.Test;

import java.util.List;

public class TestStatResolver {

    private static final int GET_CLASS_TIMES_TO_RUN = 5;

    //-----GENERATE_POSSIBLE_CLASSES TESTS-----//
    @Test
    public void noEqualValuesTest() {
        StatResolver.setStatMapping(10, 8, 6, 4);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 1);
        assert(possibleClasses.get(0).equalsIgnoreCase("SQIL"));
    }
    @Test
    public void twoEqualStatsAtTopTest() {
        StatResolver.setStatMapping(10, 10, 6, 4);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 2);
        assert(possibleClasses.contains("SQIL"));
        assert(possibleClasses.contains("QSIL"));
    }
    @Test
    public void threeEqualStatsAtTopTest() {
        StatResolver.setStatMapping(10, 10, 10, 4);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 6);
        assert(possibleClasses.contains("SQIL"));
        assert(possibleClasses.contains("SIQL"));
        assert(possibleClasses.contains("QSIL"));
        assert(possibleClasses.contains("QISL"));
        assert(possibleClasses.contains("IQSL"));
        assert(possibleClasses.contains("ISQL"));
    }
    @Test
    public void fourEqualStatsTest() {
        StatResolver.setStatMapping(10, 10, 10, 10);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 24);
        assert(possibleClasses.contains("SQIL"));
        assert(possibleClasses.contains("SQLI"));
        assert(possibleClasses.contains("SIQL"));
        assert(possibleClasses.contains("SILQ"));
        assert(possibleClasses.contains("SLQI"));
        assert(possibleClasses.contains("SLIQ"));
        assert(possibleClasses.contains("QSIL"));
        assert(possibleClasses.contains("QSLI"));
        assert(possibleClasses.contains("QISL"));
        assert(possibleClasses.contains("QILS"));
        assert(possibleClasses.contains("QLSI"));
        assert(possibleClasses.contains("QLIS"));
        assert(possibleClasses.contains("ISQL"));
        assert(possibleClasses.contains("ISLQ"));
        assert(possibleClasses.contains("IQSL"));
        assert(possibleClasses.contains("IQLS"));
        assert(possibleClasses.contains("ILSQ"));
        assert(possibleClasses.contains("ILQS"));
        assert(possibleClasses.contains("LSQI"));
        assert(possibleClasses.contains("LSIQ"));
        assert(possibleClasses.contains("LQSI"));
        assert(possibleClasses.contains("LQIS"));
        assert(possibleClasses.contains("LISQ"));
        assert(possibleClasses.contains("LIQS"));
    }
    @Test
    public void twoEqualStatsAtBottomTest() {
        StatResolver.setStatMapping(10, 8, 6, 6);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 2);
        assert(possibleClasses.contains("SQIL"));
        assert(possibleClasses.contains("SQLI"));
    }
    @Test
    public void twoEqualStatsInMiddleTest() {
        StatResolver.setStatMapping(10, 8, 8, 6);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 2);
        assert(possibleClasses.contains("SQIL"));
        assert(possibleClasses.contains("SIQL"));
    }
    @Test
    public void threeEqualStatsAtBottom() {
        StatResolver.setStatMapping(10, 4, 4, 4);
        List<String> possibleClasses = StatResolver.generatePossibleClasses();

        assert(possibleClasses.size() == 6);
        assert(possibleClasses.contains("SQIL"));
        assert(possibleClasses.contains("SQLI"));
        assert(possibleClasses.contains("SIQL"));
        assert(possibleClasses.contains("SILQ"));
        assert(possibleClasses.contains("SLQI"));
        assert(possibleClasses.contains("SLIQ"));
    }

    //-----GET_CLASS TESTS-----//
    @Test
    public void getStrengthBasedClassTest() {
        for (int i = 0; i < GET_CLASS_TIMES_TO_RUN; i++) {
            ClassType classType = StatResolver.getClass(10, 8, 8, 8);
            assert (ClassType.getStrengthBasedClasses().contains(classType));
        }
    }
    @Test
    public void getQuicknessBasedClassTest() {
        for (int i = 0; i < GET_CLASS_TIMES_TO_RUN; i++) {
            ClassType classType = StatResolver.getClass(8, 10, 8, 8);
            assert (ClassType.getQuicknessBasedClasses().contains(classType));
        }
    }
    @Test
    public void getIntelligenceBasedClassTest() {
        for (int i = 0; i < GET_CLASS_TIMES_TO_RUN; i++) {
            ClassType classType = StatResolver.getClass(8, 8, 10, 8);
            assert (ClassType.getIntelligenceBasedClasses().contains(classType));
        }
    }
    @Test
    public void getLeadershipBasedClassTest() {
        for (int i = 0; i < GET_CLASS_TIMES_TO_RUN; i++) {
            ClassType classType = StatResolver.getClass(8, 8, 8, 10);
            assert (ClassType.getLeadershipBasedClasses().contains(classType));
        }
    }
    @Test
    public void getAnyClassTest() {
        for (int i = 0; i < GET_CLASS_TIMES_TO_RUN; i++) {
            ClassType classType = StatResolver.getClass(8, 8, 8, 8);
            assert (ClassType.getAllClasses().contains(classType));
        }
    }
}
