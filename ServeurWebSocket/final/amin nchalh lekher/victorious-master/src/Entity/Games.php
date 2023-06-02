<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Validator\ValidatorInterface;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Games
 *
 * @ORM\Table(name="games")
 * @ORM\Entity
 */
class Games
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_Game", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *@Assert\NotBlank
     * @ORM\Column(name="Game_Name", type="string", length=30, nullable=false)
     */
    private $gameName;

    /**
     * @var string
     *@Assert\NotBlank
     * @ORM\Column(name="Description", type="string", length=200, nullable=false)
     */
    private $description;

    /**
     * @var string
     *@Assert\NotBlank
     * @ORM\Column(name="News", type="string", length=200, nullable=false)
     */
    private $news;

    /**
     * @var \DateTime
     *@Assert\NotBlank
     * @ORM\Column(name="News_Date", type="date")
     */
    private $newsDate;

    /**
     * @var string
     *@Assert\NotBlank
     * @ORM\Column(name="Image", type="text", length=255, nullable=false)
     */
    private $image;

    public function getIdGame(): ?int
    {
        return $this->id;
    }

    public function getGameName(): ?string
    {
        return $this->gameName;
    }

    public function setGameName(string $gameName): self
    {
        $this->gameName = $gameName;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getNews(): ?string
    {
        return $this->news;
    }

    public function setNews(string $news): self
    {
        $this->news = $news;

        return $this;
    }

    public function getNewsDate(): ?\DateTimeInterface
    {
        return $this->newsDate;
    }

    public function setNewsDate(\DateTimeInterface $newsDate): self
    {
        $this->newsDate = $newsDate;

        return $this;
    }

    public function getImage(): ?string
    {
        return $this->image;
    }

    public function setImage(string $image): self
    {
        $this->image = $image;

        return $this;
    }

    public function getId(): ?int
    {
        return $this->id;
    }


}
