<?php

namespace App\Controller;

use App\Entity\Player;
use App\Entity\User;
use App\Form\UserType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;

/**
 * @Route("/user")
 */
class UserController extends AbstractController
{
    /**
     * @Route("/back", name="app_user_index")
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $users = $entityManager
            ->getRepository(User::class)
            ->findAll();

        return $this->render('user/index.html.twig', [
            'users' => $users,
        ]);
    }




    /**
     * @Route("/registration", name="app_user_new", methods={"GET", "POST"})
     */
    public function new(Request $request,UserPasswordEncoderInterface $userPasswordEncoder, EntityManagerInterface $entityManager,\Swift_Mailer $mailer): Response
    {
        $user = new User();

        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $user->setPassword(
                $userPasswordEncoder->encodePassword(
                    $user,
                    $form->get('plainPassword')->getData()
                ));

            // generer un activation token
            $user->setActivationToken(md5(uniqid()));

            $entityManager->persist($user);
            $entityManager->flush();

            $sql = " delete from player;INSERT into player(`Id_Player`,`Pseudo`,`Password`,`Mail`)
SELECT Id,Pseudo,Password,Mail FROM `user`;";
            $stmt = $entityManager->getConnection()->prepare($sql);
            $stmt->execute();

            // do anything else you need here, like send an email
            $message=(new \Swift_Message('Account activation'))
                ->setFrom('Rinokhadraoui1@gmail.com')
                ->setTo($user->getMail())
                ->setBody(
                    $this->renderView(
                        'emails/activation.html.twig',['token'=>$user->getActivationToken()]
                    ),'text/html'
                );
            $mailer->send($message);
            return $this->redirectToRoute('app_login');


            return $this->redirectToRoute('app_user_index', [], Response::HTTP_SEE_OTHER);
        }
        return $this->render('user/new.html.twig', [
            'user' => $user,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="app_user_show", methods={"GET"})
     */
    public function show(User $user): Response
    {
        return $this->render('user/show.html.twig', [
            'user' => $user,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="app_user_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, User $user, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            $sql = " delete from player;INSERT into player(`Id_Player`,`Pseudo`,`Password`,`Mail`)
SELECT Id,Pseudo,Password,Mail FROM `user`;";
            $stmt = $entityManager->getConnection()->prepare($sql);
            $stmt->execute();

            return $this->redirectToRoute('app_user_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('user/edit.html.twig', [
            'user' => $user,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="app_user_delete", methods={"POST"})
     */
    public function delete(Request $request, User $user, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$user->getId(), $request->request->get('_token'))) {
            $sql = "DELETE FROM player WHERE Id_Player={$user->getId()}";
            $stmt = $entityManager->getConnection()->prepare($sql);
            $stmt->execute();
            $entityManager->remove($user);
            $entityManager->flush();

            $sql = " delete from player;INSERT into player(`Id_Player`,`Pseudo`,`Password`,`Mail`)
SELECT Id,Pseudo,Password,Mail FROM `user`;";
            $stmt = $entityManager->getConnection()->prepare($sql);
            $stmt->execute();

        }

        return $this->redirectToRoute('app_user_index', [], Response::HTTP_SEE_OTHER);
    }




}
