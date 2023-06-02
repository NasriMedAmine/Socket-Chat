<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Demande
 *
 * @ORM\Table(name="demande", indexes={@ORM\Index(name="idUserd", columns={"idUser"})})
 * @ORM\Entity
 */
class Demande
{
    /**
     * @var int
     *
     * @ORM\Column(name="idDemande", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nomSociete", type="text", length=255, nullable=true)
     */
    private $nomsociete;

    /**
     * @var string
     *
     * @ORM\Column(name="adresseSociete", type="text", length=255, nullable=true)
     */
    private $adressesociete;

    /**
     * @var string
     *
     * @ORM\Column(name="codeTVA", type="text", length=255, nullable=true)
     */
    private $codetva;

    /**
     * @var string
     *
     * @ORM\Column(name="typeDemandeur", type="text", length=255, nullable=false)
     */
    private $typedemandeur;

    /**
     * @var bool
     *
     * @ORM\Column(name="valide", type="boolean", nullable=false)
     */
    private $valide = '0';

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idUser")
     * })
     */
    private $iduser;

    public function getIddemande(): ?int
    {
        return $this->id;
    }

    public function getNomsociete(): ?string
    {
        return $this->nomsociete;
    }

    public function setNomsociete(?string $nomsociete): self
    {
        $this->nomsociete = $nomsociete;

        return $this;
    }

    public function getAdressesociete(): ?string
    {
        return $this->adressesociete;
    }

    public function setAdressesociete(?string $adressesociete): self
    {
        $this->adressesociete = $adressesociete;

        return $this;
    }

    public function getCodetva(): ?string
    {
        return $this->codetva;
    }

    public function setCodetva(?string $codetva): self
    {
        $this->codetva = $codetva;

        return $this;
    }

    public function getTypedemandeur(): ?string
    {
        return $this->typedemandeur;
    }

    public function setTypedemandeur(string $typedemandeur): self
    {
        $this->typedemandeur = $typedemandeur;

        return $this;
    }

    public function getValide(): ?bool
    {
        return $this->valide;
    }

    public function setValide(bool $valide): self
    {
        $this->valide = $valide;

        return $this;
    }

    public function getIduser(): ?User
    {
        return $this->iduser;
    }

    public function setIduser(?User $iduser): self
    {
        $this->iduser = $iduser;

        return $this;
    }


    public function setIduserAchref(?int $iduser): self
    {
        $this->iduser = $iduser;

        return $this;
    }




}
