package sd.academy.main;

import pl.sdacademy.database.model.dao.NfcDao;
import pl.sdacademy.database.model.dao.RunDao;
import pl.sdacademy.database.model.dao.RunMemberDao;
import pl.sdacademy.database.model.daoimplement.NfcDaoImplements;
import pl.sdacademy.database.model.daoimplement.RunDaoImlement;
import pl.sdacademy.database.model.daoimplement.RunMemberImplement;
import pl.sdacademy.database.model.entity.NfcTag;
import pl.sdacademy.database.model.entity.Run;
import pl.sdacademy.database.model.entity.RunMember;

public class Main {

    public static void main(String[] args) {

        oneToManyTest();
    }

    private static void loadTest() {

        RunMemberDao memberDao = new RunMemberImplement();
        RunDao runDao = new RunDaoImlement();

        Run run = new Run();
        run.setName("wesoly");
        run.setMembersLimit(100);
        runDao.save(run);

        for (int i = 0; i <3; i++) {
            RunMember runMember = new RunMember();
            runMember.setName("Damian" + i);
            runMember.setRun(run);
            memberDao.save(runMember);
        }
        Run savedRun = runDao.findById(run.getId());
        System.out.println(savedRun.getName());
        System.out.println("members count: " + savedRun.getMembers().size());
    }

    private static void oneToManyTest(){

        RunMemberDao memberDao = new RunMemberImplement();
        RunDao runDao = new RunDaoImlement();
        NfcDao nfcDao = new NfcDaoImplements();

        Run run = new Run();
        run.setName("wesoly bieg");
        run.setMembersLimit(100);
        runDao.save(run);

        RunMember runMember = new RunMember();
        runMember.setName("Damian");
        runMember.setRun(run);
        memberDao.save(runMember);

        NfcTag nfcTag = new NfcTag();
        nfcTag.setId(1);
        nfcTag.setSerialNumber(12345);
    }
}
