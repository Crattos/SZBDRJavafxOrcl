/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     25.04.2017 10:25:21                          */
/*==============================================================*/


alter table DRUZYNY
   drop constraint FK_DRUZYNY_RELATIONS_MIASTA;

alter table KARY
   drop constraint FK_KARY_KARY_SPOTKANI;

alter table KARY
   drop constraint FK_KARY_KARY2_DRUZYNY;

alter table KARY
   drop constraint FK_KARY_KARY3_PILKARZE;

alter table PILKARZE
   drop constraint FK_PILKARZE_DRUZYNA_P_DRUZYNY;

alter table SPOTKANIA
   drop constraint FK_SPOTKANI_RELATIONS_DRUZYNY;

alter table SPOTKANIA
   drop constraint FK_SPOTKANI_SEDZIOWIE_SEDZIOWI;

alter table SPOTKANIA
   drop constraint FK_SPOTKANI_SPOTKANIE_MIASTA;

alter table SPOTKANIA
   drop constraint FK_SPOTKANI_GOSPODARZ_DRUZYNY;

alter table TRENERZY
   drop constraint FK_TRENERZY_DRUZYNA_T_DRUZYNY;

alter table WYNIK
   drop constraint FK_WYNIK_WYNIK_SPOTKANI;

alter table WYNIK
   drop constraint FK_WYNIK_WYNIK2_DRUZYNY;

alter table WYNIK
   drop constraint FK_WYNIK_WYNIK3_PILKARZE;

drop index "Relationship_3_FK";

drop table DRUZYNY cascade constraints;

drop index KARY3_FK;

drop index KARY2_FK;

drop index KARY_FK;

drop table KARY cascade constraints;

drop table MIASTA cascade constraints;

drop index "Druzyna_pilkarze_FK";

drop table PILKARZE cascade constraints;

drop table SEDZIOWIE cascade constraints;

drop index "Spotkanie_miasto_FK";

drop index "Relationship_6_FK";

drop index "gospodarz_FK";

drop index "Sedziowie_spotkanie_FK";

drop table SPOTKANIA cascade constraints;

drop index "Druzyna_trener_FK";

drop table TRENERZY cascade constraints;

drop index WYNIK3_FK;

drop index WYNIK2_FK;

drop index WYNIK_FK;

drop table WYNIK cascade constraints;

/*==============================================================*/
/* Table: DRUZYNY                                               */
/*==============================================================*/
create table DRUZYNY 
(
   ID_DRUZYNY           NUMBER               not null,
   ID_MIASTA            NUMBER               not null,
   NAZWA_DRUZYNY        VARCHAR2(25),
   PUNKTY               NUMBER,
   BRAMKI               NUMBER,
   ILOSC_SPOTKAN        NUMBER,
   constraint PK_DRUZYNY primary key (ID_DRUZYNY)
);

/*==============================================================*/
/* Index: "Relationship_3_FK"                                   */
/*==============================================================*/
create index "Relationship_3_FK" on DRUZYNY (
   ID_MIASTA ASC
);

/*==============================================================*/
/* Table: KARY                                                  */
/*==============================================================*/
create table KARY 
(
   ID_SPOTKANIA         NUMBER               not null,
   ID_DRUZYNY           NUMBER               not null,
   ID_PILKARZA          NUMBER               not null,
   MINUTA_KARY          INTEGER,
   KARA                 VARCHAR2(30),
   constraint PK_KARY primary key (ID_SPOTKANIA, ID_DRUZYNY, ID_PILKARZA)
);

/*==============================================================*/
/* Index: KARY_FK                                               */
/*==============================================================*/
create index KARY_FK on KARY (
   ID_SPOTKANIA ASC
);

/*==============================================================*/
/* Index: KARY2_FK                                              */
/*==============================================================*/
create index KARY2_FK on KARY (
   ID_DRUZYNY ASC
);

/*==============================================================*/
/* Index: KARY3_FK                                              */
/*==============================================================*/
create index KARY3_FK on KARY (
   ID_PILKARZA ASC
);

/*==============================================================*/
/* Table: MIASTA                                                */
/*==============================================================*/
create table MIASTA 
(
   ID_MIASTA            NUMBER               not null,
   NAZWA_MIASTA         VARCHAR2(25),
   constraint PK_MIASTA primary key (ID_MIASTA)
);

/*==============================================================*/
/* Table: PILKARZE                                              */
/*==============================================================*/
create table PILKARZE 
(
   ID_PILKARZA          NUMBER               not null,
   ID_DRUZYNY           NUMBER,
   IMIE_PILKARZA        VARCHAR2(20),
   NAZWISKO_PILKARZA    VARCHAR2(30),
   WIEK_PILKARZA        DATE,
   POZYCJA              VARCHAR2(20),
   NARODOWOSC_PILKARZA  VARCHAR2(20),
   constraint PK_PILKARZE primary key (ID_PILKARZA)
);

/*==============================================================*/
/* Index: "Druzyna_pilkarze_FK"                                 */
/*==============================================================*/
create index "Druzyna_pilkarze_FK" on PILKARZE (
   ID_DRUZYNY ASC
);

/*==============================================================*/
/* Table: SEDZIOWIE                                             */
/*==============================================================*/
create table SEDZIOWIE 
(
   ID_SEDZI             NUMBER               not null,
   IMIE_SEDZI           VARCHAR2(20),
   NAZWISKO_SEDZI       VARCHAR2(30),
   constraint PK_SEDZIOWIE primary key (ID_SEDZI)
);

/*==============================================================*/
/* Table: SPOTKANIA                                             */
/*==============================================================*/
create table SPOTKANIA 
(
   ID_SPOTKANIA         NUMBER               not null,
   ID_SEDZI             NUMBER               not null,
   ID_DRUZYNY           NUMBER               not null,
   ID_MIASTA            NUMBER               not null,
   DRU_ID_DRUZYNY       NUMBER               not null,
   BRAMKI_D1            INTEGER,
   BRAMKI_D2            INTEGER,
   DATA_SPOTKANIA       DATE,
   constraint PK_SPOTKANIA primary key (ID_SPOTKANIA)
);

/*==============================================================*/
/* Index: "Sedziowie_spotkanie_FK"                              */
/*==============================================================*/
create index "Sedziowie_spotkanie_FK" on SPOTKANIA (
   ID_SEDZI ASC
);

/*==============================================================*/
/* Index: "gospodarz_FK"                                        */
/*==============================================================*/
create index "gospodarz_FK" on SPOTKANIA (
   DRU_ID_DRUZYNY ASC
);

/*==============================================================*/
/* Index: "Relationship_6_FK"                                   */
/*==============================================================*/
create index "Relationship_6_FK" on SPOTKANIA (
   ID_DRUZYNY ASC
);

/*==============================================================*/
/* Index: "Spotkanie_miasto_FK"                                 */
/*==============================================================*/
create index "Spotkanie_miasto_FK" on SPOTKANIA (
   ID_MIASTA ASC
);

/*==============================================================*/
/* Table: TRENERZY                                              */
/*==============================================================*/
create table TRENERZY 
(
   ID_TRENERA           NUMBER               not null,
   ID_DRUZYNY           NUMBER,
   IMIE_TRENERA         VARCHAR2(20),
   NAZWISKO_TRENERA     VARCHAR2(30),
   WIEK_TRENERA         DATE,
   NARODOWOSC_TRENERA   VARCHAR2(20),
   constraint PK_TRENERZY primary key (ID_TRENERA)
);

/*==============================================================*/
/* Index: "Druzyna_trener_FK"                                   */
/*==============================================================*/
create index "Druzyna_trener_FK" on TRENERZY (
   ID_DRUZYNY ASC
);

/*==============================================================*/
/* Table: WYNIK                                                 */
/*==============================================================*/
create table WYNIK 
(
   ID_SPOTKANIA         NUMBER               not null,
   ID_DRUZYNY           NUMBER               not null,
   ID_PILKARZA          NUMBER               not null,
   MINUTA_WYNIKU        INTEGER,
   constraint PK_WYNIK primary key (ID_SPOTKANIA, ID_DRUZYNY, ID_PILKARZA)
);

/*==============================================================*/
/* Index: WYNIK_FK                                              */
/*==============================================================*/
create index WYNIK_FK on WYNIK (
   ID_SPOTKANIA ASC
);

/*==============================================================*/
/* Index: WYNIK2_FK                                             */
/*==============================================================*/
create index WYNIK2_FK on WYNIK (
   ID_DRUZYNY ASC
);

/*==============================================================*/
/* Index: WYNIK3_FK                                             */
/*==============================================================*/
create index WYNIK3_FK on WYNIK (
   ID_PILKARZA ASC
);

alter table DRUZYNY
   add constraint FK_DRUZYNY_RELATIONS_MIASTA foreign key (ID_MIASTA)
      references MIASTA (ID_MIASTA);

alter table KARY
   add constraint FK_KARY_KARY_SPOTKANI foreign key (ID_SPOTKANIA)
      references SPOTKANIA (ID_SPOTKANIA);

alter table KARY
   add constraint FK_KARY_KARY2_DRUZYNY foreign key (ID_DRUZYNY)
      references DRUZYNY (ID_DRUZYNY);

alter table KARY
   add constraint FK_KARY_KARY3_PILKARZE foreign key (ID_PILKARZA)
      references PILKARZE (ID_PILKARZA);

alter table PILKARZE
   add constraint FK_PILKARZE_DRUZYNA_P_DRUZYNY foreign key (ID_DRUZYNY)
      references DRUZYNY (ID_DRUZYNY);

alter table SPOTKANIA
   add constraint FK_SPOTKANI_RELATIONS_DRUZYNY foreign key (ID_DRUZYNY)
      references DRUZYNY (ID_DRUZYNY);

alter table SPOTKANIA
   add constraint FK_SPOTKANI_SEDZIOWIE_SEDZIOWI foreign key (ID_SEDZI)
      references SEDZIOWIE (ID_SEDZI);

alter table SPOTKANIA
   add constraint FK_SPOTKANI_SPOTKANIE_MIASTA foreign key (ID_MIASTA)
      references MIASTA (ID_MIASTA);

alter table SPOTKANIA
   add constraint FK_SPOTKANI_GOSPODARZ_DRUZYNY foreign key (DRU_ID_DRUZYNY)
      references DRUZYNY (ID_DRUZYNY);

alter table TRENERZY
   add constraint FK_TRENERZY_DRUZYNA_T_DRUZYNY foreign key (ID_DRUZYNY)
      references DRUZYNY (ID_DRUZYNY);

alter table WYNIK
   add constraint FK_WYNIK_WYNIK_SPOTKANI foreign key (ID_SPOTKANIA)
      references SPOTKANIA (ID_SPOTKANIA);

alter table WYNIK
   add constraint FK_WYNIK_WYNIK2_DRUZYNY foreign key (ID_DRUZYNY)
      references DRUZYNY (ID_DRUZYNY);

alter table WYNIK
   add constraint FK_WYNIK_WYNIK3_PILKARZE foreign key (ID_PILKARZA)
      references PILKARZE (ID_PILKARZA);

