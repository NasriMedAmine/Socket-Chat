<?php

namespace App\Entity;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Symfony\Componet\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;

/**
 * Publicite
 *
 * @ORM\Table(name="publicite")
 * @ORM\Entity(repositoryClass="App\Repository\PubliciteRepository")
 */
class Publicite
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_publicite", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="text", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="text", length=255, nullable=false)
     */
    private $image;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_debut", type="date", nullable=false)
     */
    private $dateDebut;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_fin", type="date", nullable=false)
     */
    private $dateFin;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_proprietaire", type="text", length=255, nullable=false)
     */
    private $nomProprietaire;

    /**
     * @var float
     *
     * @ORM\Column(name="prix", type="float", precision=10, scale=0, nullable=false)
     */
    private $prix;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     *
     */
    private $description;

    /**
     * @ORM\Column(type="string", length=50000, nullable=true)
     */
    private $video;

    /**
     * @ORM\Column(type="string", length=50000, nullable=true)
     */
    private $docs;

    /**
     * @ORM\OneToMany(targetEntity=PubLike::class, mappedBy="publicite")
     */
    private $likes;

    public function __construct()
    {
        $this->likes = new ArrayCollection();
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(?string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getImage()
    {
        return $this->image;
    }

    public function setImage($image)
    {
        $this->image = $image;

        return $this;
    }

    public function getDateDebut(): ?\DateTimeInterface
    {
        return $this->dateDebut;
    }

    public function setDateDebut(\DateTimeInterface $dateDebut): self
    {
        $this->dateDebut = $dateDebut;

        return $this;
    }

    public function getDateFin(): ?\DateTimeInterface
    {
        return $this->dateFin;
    }

    public function setDateFin(\DateTimeInterface $dateFin): self
    {
        $this->dateFin = $dateFin;

        return $this;
    }

    public function getNomProprietaire(): ?string
    {
        return $this->nomProprietaire;
    }

    public function setNomProprietaire(string $nomProprietaire): self
    {
        $this->nomProprietaire = $nomProprietaire;

        return $this;
    }

    public function getPrix(): ?float
    {
        return $this->prix;
    }

    public function setPrix(float $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getVideo()
    {
        return $this->video;
    }

    public function setVideo($video)
    {
        $this->video = $video;

        return $this;
    }

    public function getDocs()
    {
        return $this->docs;
    }

    public function setDocs($docs)
    {
        $this->docs = $docs;

        return $this;
    }

    /**
     * @return Collection<int, PubLike>
     */
    public function getLikes(): Collection
    {
        return $this->likes;
    }

    public function addLike(PubLike $like): self
    {
        if (!$this->likes->contains($like)) {
            $this->likes[] = $like;
            $like->setPublicite($this);
        }

        return $this;
    }

    public function removeLike(PubLike $like): self
    {
        if ($this->likes->removeElement($like)) {
            // set the owning side to null (unless already changed)
            if ($like->getPublicite() === $this) {
                $like->setPublicite(null);
            }
        }

        return $this;
    }


}
