--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: clothingtype; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.clothingtype AS ENUM (
    'headwear',
    'midSection',
    'lowerSection',
    'accessory',
    'footwear'
);


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: accounts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.accounts (
    userid integer NOT NULL,
    gender character varying(15),
    zipcode integer,
    username character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(50) NOT NULL
);


--
-- Name: accounts_userid_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.accounts_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: accounts_userid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.accounts_userid_seq OWNED BY public.accounts.userid;


--
-- Name: clothing; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.clothing (
    cid integer NOT NULL,
    price numeric(15,6),
    sitelink text,
    isadult boolean,
    genderpref character varying(15),
    title text NOT NULL,
    img text,
    itemtype text NOT NULL
);


--
-- Name: clothing_cid_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.clothing_cid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: clothing_cid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.clothing_cid_seq OWNED BY public.clothing.cid;


--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


--
-- Name: outfit; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.outfit (
    outfitid integer NOT NULL,
    headwear integer,
    lowersection integer,
    midsection integer,
    footwear integer,
    accessory integer
);


--
-- Name: outfit_outfitid_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.outfit_outfitid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: outfit_outfitid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.outfit_outfitid_seq OWNED BY public.outfit.outfitid;


--
-- Name: savesclothing; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.savesclothing (
    cid integer NOT NULL,
    userid integer NOT NULL,
    createdat timestamp without time zone NOT NULL
);


--
-- Name: savesoutfit; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.savesoutfit (
    outfitid integer NOT NULL,
    userid integer NOT NULL,
    createdat timestamp without time zone NOT NULL
);


--
-- Name: accounts userid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.accounts ALTER COLUMN userid SET DEFAULT nextval('public.accounts_userid_seq'::regclass);


--
-- Name: clothing cid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clothing ALTER COLUMN cid SET DEFAULT nextval('public.clothing_cid_seq'::regclass);


--
-- Name: outfit outfitid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit ALTER COLUMN outfitid SET DEFAULT nextval('public.outfit_outfitid_seq'::regclass);


--
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.accounts (userid, gender, zipcode, username, email, password) FROM stdin;
1	Male	12345	hellothisistest	z	z
2	Male	12345	user1	user1@gmail.com	12345
3	Female	23456	user2	user2@gmail.com	223344
4	Unisex	34567	user3	user3@gmail.com	565656
5	Male	45455	user4	user4@gmail.com	678562
6	Female	58585	user5	user5@gmail.com	78489
7	Unisex	62584	user6	user6@gmail.com	85624
8	Male	78451	user7	user7@gmail.com	899999
9	Female	14562	user8	user8@gmail.com	9841255w
10	Unisex	34567	user9	user9@gmail.com	565dawd656
11	Male	54714	user10	user10@gmail.com	1ww2$lw2345
12	Female	23456	user11	user11@gmail.com	zwa92djn
13	Unisex	99999	user12	user12@gmail.com	pwaoei22
14	Male	52455	user13	user13@gmail.com	woapdo22
15	Female	23456	user14	user14@gmail.com	223344
16	Unisex	99985	user15	user15@gmail.com	feoaji92
17	Male	45245	user16	user16@gmail.com	dunno
18	Female	78956	user17	user17@gmail.com	vfjid
19	Unisex	34567	user18	user18@gmail.com	awdaw2
20	Male	85461	user19	user19@gmail.com	3489ajwd
21	Female	23456	user20	user20@gmail.com	283aos
\.


--
-- Data for Name: clothing; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.clothing (cid, price, sitelink, isadult, genderpref, title, img, itemtype) FROM stdin;
1	12.990000	https://www.target.com/p/men-s-washed-baseball-cap-goodfellow-co-153/-/A-52525085?preselect=52405871#lnk=sametab	t	Male	Mens Washed Baseball Cap	https://target.scene7.com/is/image/Target/GUEST_b2d5c8ce-65d4-4731-9eff-689442133521?fmt=webp&wid=1400&qlt=80	headwear
2	14.990000	https://www.target.com/p/men-39-s-star-wars-mandalorian-baby-yoda-cap-black-one-size/-/A-79710073#lnk=sametab	t	Unisex	Mens Star Wars Mandalorian Baby Yoda Cap	https://target.scene7.com/is/image/Target/GUEST_e880cd10-0d96-45be-9b7e-86c56c683d5a?fmt=webp&wid=1400&qlt=80	headwear
3	12.990000	https://www.target.com/p/women-s-floppy-hat-a-new-day-153/-/A-53353986?preselect=52844684#lnk=sametab	t	Female	Womens Floppy Hat - A New Day	https://target.scene7.com/is/image/Target/GUEST_d2a5b07e-d080-4521-9fd6-7067ce90727d?fmt=webp&wid=1400&qlt=80	headwear
4	22.000000	https://www.target.com/p/women-39-s-wide-down-brim-fedora-hat-a-new-day-8482-black-one-size/-/A-79653697#lnk=sametab	t	Female	Womens Wide Down Brim Fedora Hat	https://target.scene7.com/is/image/Target/GUEST_cdb3ea49-0764-427f-94cb-862a1637e449?fmt=webp&wid=1400&qlt=80	headwear
5	5.000000	https://www.target.com/p/men-s-circular-knit-cuffed-beanie-goodfellow-co-one-size/-/A-79691403?preselect=79483834#lnk=sametab	t	Male	Mens Circular Knit Cuffed Beanie	https://target.scene7.com/is/image/Target/GUEST_cd4a2bd4-1957-45b6-be5f-1a3018a2c7f4?fmt=webp&wid=1400&qlt=80	headwear
6	10.000000	https://www.target.com/p/women-s-knit-headband-universal-thread-one-size/-/A-81297999?preselect=79436637#lnk=sametab	t	Female	Womens Knit Headband	https://target.scene7.com/is/image/Target/GUEST_47771d09-24df-403d-ac46-bb0c6ddd746f?fmt=webp&wid=1400&qlt=80	headwear
7	17.990000	https://www.target.com/p/men-s-fedora-hat-goodfellow-co-black/-/A-79708804?preselect=79630798#lnk=sametab	t	Male	Mens Fedora Hat	https://target.scene7.com/is/image/Target/GUEST_3b1e490f-4cc6-48c3-947c-3d90c15c7b6a?fmt=webp&wid=1400&qlt=80	headwear
8	15.000000	https://www.target.com/p/women-39-s-beret-knit-hat-a-new-day-8482-black-one-size/-/A-79653691#lnk=sametab	t	Unisex	Womens Beret Knit Hat	https://target.scene7.com/is/image/Target/GUEST_d26f7779-ef79-4aaf-93f3-90a27920d13a?fmt=webp&wid=1400&qlt=80	headwear
9	17.990000	https://www.target.com/p/men-s-classic-panama-fedora-hat-goodfellow-co-gray/-/A-79708805?preselect=79630800#lnk=sametab	t	Male	Mens Classic Panama Fedora Hat	https://target.scene7.com/is/image/Target/GUEST_eeb8b05e-dca2-4292-9842-32e3d3eb89d5?fmt=webp&wid=1400&qlt=80	headwear
10	17.990000	https://www.target.com/p/men-s-ripstop-bonnie-hat-goodfellow-co-black/-/A-78608784?preselect=77789799#lnk=sametab	t	Male	Mens Ripstop Bonnie Hat	https://target.scene7.com/is/image/Target/GUEST_73da050e-c904-425a-8808-0575d75cae18?fmt=webp&wid=1400&qlt=80	headwear
11	15.800000	https://www.target.com/p/pace-sportswear-traditional-cycling-cap-m-black/-/A-77447234#lnk=sametab	t	Unisex	Pace Sportswear Traditional Cycling Cap	https://target.scene7.com/is/image/Target/GUEST_67b27856-5638-4519-9d87-d8c8c52b3fed?fmt=webp&wid=1400&qlt=80	headwear
12	18.000000	https://www.target.com/p/volcom-boys-quarter-straw-hat/-/A-81474697?preselect=81474696#lnk=sametab	f	Male	Volcom Boys Quarter Straw Hat	https://target.scene7.com/is/image/Target/GUEST_bd22c1e6-5eda-4557-8f38-89e63d9f0495?fmt=webp&wid=1400&qlt=80	headwear
13	22.000000	https://www.target.com/p/mizuno-tour-golf-visor/-/A-76082384?preselect=76104057#lnk=sametab	t	Unisex	Mizuno Tour Golf Visor	https://target.scene7.com/is/image/Target/GUEST_499e198f-c7b4-4974-9550-b59ae18264d7?fmt=webp&wid=1400&qlt=80	headwear
14	36.000000	https://www.target.com/p/mizuno-large-brim-sun-golf-hat/-/A-76115763?preselect=76103098#lnk=sametab	t	Male	Mizuno Large Brim Sun Golf Hat	https://target.scene7.com/is/image/Target/GUEST_176cd54e-f49d-429c-9b51-c7e721f3a402?fmt=webp&wid=1400&qlt=80	headwear
15	9.990000	https://www.target.com/p/boys-39-fortnite-classic-beanie-black/-/A-79635471#lnk=sametab	f	Unisex	Fortnite Classic Beanie	https://target.scene7.com/is/image/Target/GUEST_0f8f755b-0d09-4e29-b9b8-35f6cf492691?fmt=webp&wid=1400&qlt=80	headwear
16	17.990000	https://www.target.com/p/men-s-slim-band-panama-fedora-hat-goodfellow-co-navy/-/A-79708809?preselect=79630805#lnk=sametab	t	Male	Mens Slim Band Panama Fedora Hat	https://target.scene7.com/is/image/Target/GUEST_94580077-8434-4159-af06-317fa803af80?fmt=webp&wid=1400&qlt=80	headwear
17	12.990000	https://www.target.com/p/boys-39-trapper-cat-38-jack-8482-red-one-size/-/A-79466867#lnk=sametab	f	Unisex	Trapper Hat	https://target.scene7.com/is/image/Target/GUEST_06dc5b24-9218-4de0-a997-d88fbe15cd2e?fmt=webp&wid=1400&qlt=80	headwear
18	7.990000	https://www.target.com/p/girls-39-teddy-fleece-beanie-cat-38-jack-8482-white/-/A-79431707#lnk=sametab	f	Female	Girls Teddy Fleece Beanie	https://target.scene7.com/is/image/Target/GUEST_5425952c-3917-4ee3-b79d-888c395f5ea0?fmt=webp&wid=1400&qlt=80	headwear
19	9.990000	https://www.target.com/p/toddler-boys-shark-swim-hat-cat-jack-gray/-/A-76611972?preselect=76491503#lnk=sametab	f	Male	Toddler Boys Shark Swim Hat	https://target.scene7.com/is/image/Target/GUEST_abe38380-ae76-4080-8f67-9a0c7e1d859e?wid=325&hei=325&qlt=80&fmt=webp	headwear
20	9.990000	https://www.target.com/p/toddler-girls-rainbow-unicorn-hat-cat-jack/-/A-76611970?preselect=76491505#lnk=sametab	f	Female	Toddler Girls Rainbow Unicorn Hat	https://target.scene7.com/is/image/Target/GUEST_d07feb3d-eff1-4950-900d-57833bc7b4f2?fmt=webp&wid=1400&qlt=80	headwear
21	24.990000	https://www.target.com/p/denizen-174-from-levi-s-174-men-s-twill-jogger-pants/-/A-54551744?preselect=53360301#lnk=sametab	t	Male	DENIZEN From Levis Mens Twill Jogger Pants	https://target.scene7.com/is/image/Target/GUEST_fa0298a7-f851-4a3b-a864-d0d1c5c0dc72?fmt=webp&wid=1400&qlt=80	lowerSection
22	23.990000	https://www.target.com/p/women-s-high-rise-corduroy-skinny-jeans-universal-thread/-/A-79832680?preselect=79397136#lnk=sametab	t	Female	Womens High-Rise Corduroy Skinny Jeans	https://target.scene7.com/is/image/Target/GUEST_20b86df4-3a13-41c0-af13-2d87ba261fdf?fmt=webp&wid=1400&qlt=80	lowerSection
23	39.990000	https://www.target.com/p/dickies-men-s-flex-regular-fit-straight-leg-tough-max-ripstop-carpenter-pants/-/A-53218602?preselect=53044887#lnk=sametab	t	Male	Dickies Mens FLEX Regular Fit Straight Leg Tough Max	https://target.scene7.com/is/image/Target/GUEST_6c29371c-62d3-41e1-aa39-6944d6b57d24?fmt=webp&wid=1400&qlt=80	lowerSection
24	24.990000	https://www.target.com/p/lucky-brand-womens-boyfriend-short/-/A-81485846?preselect=81485849#lnk=sametab	t	Female	Lucky Brand Womens Boyfriend Short	https://target.scene7.com/is/image/Target/GUEST_7ccfc855-da31-4e65-8d0b-60c3fdbc3441?fmt=webp&wid=1400&qlt=80	lowerSection
25	36.990000	https://www.target.com/p/women-s-birdcage-midi-skirt-who-what-wear-black/-/A-81417971?preselect=79951543#lnk=sametab	t	Female	Womens Birdcage Midi Skirt	https://target.scene7.com/is/image/Target/GUEST_b767f4f2-830d-4270-8251-5c3604e73aef?fmt=webp&wid=1400&qlt=80	lowerSection
26	19.990000	https://www.target.com/p/wrangler-men-s-relaxed-fit-jeans-with-flex/-/A-52673634?preselect=52428339#lnk=sametab	t	Male	Wrangler Mens Relaxed Fit Jeans with FLEX	https://target.scene7.com/is/image/Target/GUEST_72d25ca7-168b-4c16-a267-76220ee45edb?fmt=webp&wid=1400&qlt=80	lowerSection
27	14.990000	https://www.target.com/p/women-s-plus-size-mid-rise-ankle-length-leggings-ava-viv-153/-/A-54327777?preselect=54008178#lnk=sametab	t	Female	Womens Plus Size Mid-Rise Ankle Length Leggings	https://target.scene7.com/is/image/Target/GUEST_f96cd11d-9532-4953-afa9-8bb973c21b5d?fmt=webp&wid=1400&qlt=80	lowerSection
28	25.990000	https://www.target.com/p/men-s-slim-lightweight-denim-goodfellow-co/-/A-78653190?preselect=77571348#lnk=sametab	t	Male	Mens Slim Lightweight Denim	https://target.scene7.com/is/image/Target/GUEST_f5b4c44c-7ff3-4b27-90c6-e9d5f2361e8b?fmt=webp&wid=1400&qlt=80	lowerSection
29	36.990000	https://www.target.com/p/women-s-high-rise-cropped-pants-who-what-wear/-/A-80254910?preselect=79950545#lnk=sametab	t	Female	Womens High-Rise Cropped Pants	https://target.scene7.com/is/image/Target/GUEST_033ef1f1-888c-4771-b996-ec330e9258d0?fmt=webp&wid=1400&qlt=80	lowerSection
30	24.990000	https://www.target.com/p/men-s-10-5-rotary-hybrid-shorts-goodfellow-co-153/-/A-52732142?preselect=52619167#lnk=sametab	t	Male	Mens Rotary Hybrid Shorts	https://target.scene7.com/is/image/Target/GUEST_c6f27f5f-b05d-4b6f-8fed-6aab7a926dc9?fmt=webp&wid=1400&qlt=80	lowerSection
31	27.990000	https://www.target.com/p/denizen-174-from-levi-s-174-women-s-modern-slim-jeans-marissa/-/A-52118874#lnk=sametab	t	Female	DENIZEN from Levis Modern Slim Jeans	https://target.scene7.com/is/image/Target/GUEST_69f4c0e9-acac-4e3e-a9c7-c6b2dcbd23f4?fmt=webp&wid=1400&qlt=80	lowerSection
32	30.000000	https://www.target.com/p/men-s-heather-golf-shorts-all-in-motion/-/A-77602992?preselect=77287439#lnk=sametab	t	Male	Mens Heather Golf Shorts	https://target.scene7.com/is/image/Target/GUEST_a69ad8b8-9ace-42f8-bc03-e11bd2f549cf?fmt=webp&wid=1400&qlt=80	lowerSection
33	12.990000	https://www.target.com/p/girls-bootcut-jeans-cat-jack-153/-/A-50722989?preselect=50621034#lnk=sametab	f	Female	Girls Bootcut Jeans	https://target.scene7.com/is/image/Target/GUEST_3f28e5f4-2447-4df7-9055-e6177cc04ddd?fmt=webp&wid=1400&qlt=80	lowerSection
34	20.000000	https://www.target.com/p/men-s-train-pants-all-in-motion/-/A-77602490?preselect=77286731#lnk=sametab	t	Male	Mens Train Pants	https://target.scene7.com/is/image/Target/GUEST_b2471b89-751b-4614-81a3-2486d6d3fe09?fmt=webp&wid=1400&qlt=80	lowerSection
35	14.990000	https://www.target.com/p/french-toast-girls-uniform-skort-with-bow-navy/-/A-79762719?preselect=79449864#lnk=sametab	f	Female	French Toast Girls Uniform Skort with Bow	https://target.scene7.com/is/image/Target/GUEST_6a0c29ae-66b8-46d3-8930-4ee976a8da5a?fmt=webp&wid=1400&qlt=80	lowerSection
36	16.990000	https://www.target.com/p/boys-lined-pull-on-jogger-fit-pants-cat-jack/-/A-79435666?preselect=79384069#lnk=sametab	f	Male	Boys Lined Pull-On Jogger Fit Pants	https://target.scene7.com/is/image/Target/GUEST_599460a4-9d1d-4285-9dad-faff64e46332?fmt=webp&wid=1400&qlt=80	lowerSection
37	12.990000	https://www.target.com/p/girls-flat-front-stretch-uniform-shorts-cat-jack/-/A-79315363?preselect=78855963#lnk=sametab	f	Female	Flat Front Stretch Uniform Shorts	https://target.scene7.com/is/image/Target/GUEST_9197e4a0-cc57-4b84-90a7-2044b578d801?fmt=webp&wid=1400&qlt=80	lowerSection
38	14.000000	https://www.target.com/p/boys-geometric-ombre-performance-shorts-all-in-motion/-/A-78791443?preselect=78374858#lnk=sametab	f	Male	Boys Geometric Ombre Performance Shorts	https://target.scene7.com/is/image/Target/GUEST_b8c7d5fd-034d-4ca6-9f90-112631388664?fmt=webp&wid=1400&qlt=80	lowerSection
39	12.990000	https://www.target.com/p/boys-stretch-straight-fit-jeans-cat-jack-blue/-/A-52211348?preselect=52189168#lnk=sametab	f	Male	Boys Stretch Straight Fit Jeans	https://target.scene7.com/is/image/Target/GUEST_e7cdaccb-4f8c-418d-95db-eb12e4089241?fmt=webp&wid=1400&qlt=80	lowerSection
40	6.000000	https://www.target.com/p/girls-polka-dot-leggings-cat-jack-cream/-/A-77552172?preselect=77246484#lnk=sametab	f	Female	Polka Dot Leggings	https://target.scene7.com/is/image/Target/GUEST_7986e9fd-31e4-4f01-82e8-0323d0e6b7b2?fmt=webp&wid=1400&qlt=80	lowerSection
41	17.990000	https://www.target.com/p/dickies-men-s-long-sleeve-heavyweight-crew-neck-tee/-/A-15193617?preselect=15183327#lnk=sametab	t	Male	Dickies Mens Long Sleeve Heavyweight Crew Neck Tee	https://target.scene7.com/is/image/Target/GUEST_8b5cf923-8430-4bb0-b077-ea2df3ec8b92?fmt=webp&wid=1400&qlt=80	midSection
42	29.990000	https://www.target.com/p/women-s-long-sleeve-faux-leather-button-down-shirt-prologue/-/A-80159937?preselect=79897796#lnk=sametab	t	Female	Long Sleeve Faux Leather Button-Down Shirt	https://target.scene7.com/is/image/Target/GUEST_bef47766-b7c9-403b-a883-5ad6dce471d5?fmt=webp&wid=1400&qlt=80	midSection
43	24.990000	https://www.target.com/p/women-s-bishop-long-sleeve-blouse-universal-thread/-/A-80309307?preselect=80125205#lnk=sametab	t	Female	Bishop Long Sleeve Blouse	https://target.scene7.com/is/image/Target/GUEST_d5c50556-2d9c-4be9-b752-7cfd5ae3d816?fmt=webp&wid=1400&qlt=80	midSection
44	9.990000	https://www.target.com/p/hanes-1901-men-s-short-sleeve-t-shirt/-/A-53660262?preselect=53625701#lnk=sametab	t	Male	Hanes 1901 Mens Short Sleeve T-Shirt	https://target.scene7.com/is/image/Target/GUEST_175b84b1-6064-41fc-a069-92acb75d3625?fmt=webp&wid=1400&qlt=80	midSection
45	20.000000	https://www.target.com/p/women-s-long-sleeve-button-down-flannel-shirt-universal-thread/-/A-79802830?preselect=79687857#lnk=sametab	t	Female	Long Sleeve Button-Down Flannel Shirt	https://target.scene7.com/is/image/Target/GUEST_f37fcdea-e89d-4350-8f00-21aac64293de?fmt=webp&wid=1400&qlt=80	midSection
46	29.990000	https://www.target.com/p/women-s-striped-crewneck-pullover-sweater-with-lace-up-side-detail-knox-rose/-/A-79518349?preselect=79393175#lnk=sametab	t	Female	Striped Crewneck Pullover Sweater	https://target.scene7.com/is/image/Target/GUEST_000b6f34-a537-46b4-af19-ec0d2386e7c2?fmt=webp&wid=1400&qlt=80	midSection
47	11.990000	https://www.target.com/p/men-39-s-taco-bell-tank-top-gray-xl/-/A-79429680#lnk=sametab	t	Male	Mens Taco Bell Tank Top	https://target.scene7.com/is/image/Target/GUEST_4892dbc5-e043-4ef4-937e-3b210a28b228?fmt=webp&wid=1400&qlt=80	midSection
48	15.990000	https://www.target.com/p/hanes-men-s-ecosmart-fleece-full-zip-hooded-sweatshirt/-/A-54278503?preselect=54236004#lnk=sametab	t	Unisex	EcoSmart Fleece Full-Zip Hooded Sweatshirt	https://target.scene7.com/is/image/Target/GUEST_ce449fa7-a494-4fce-b643-341f0d2ba332?wid=325&hei=325&qlt=80&fmt=webp	midSection
49	8.000000	https://www.target.com/p/women-s-slim-fit-linen-tank-top-a-new-day/-/A-79859664?preselect=79699043#lnk=sametab	t	Female	Slim Fit Linen Tank Top	https://target.scene7.com/is/image/Target/GUEST_a9770994-f6cb-4f89-a576-fd868a25fd36?fmt=webp&wid=1400&qlt=80	midSection
50	19.990000	https://www.target.com/p/men-s-standard-fit-printed-short-sleeve-poplin-button-down-shirt-goodfellow-co/-/A-77381783?preselect=79622456#lnk=sametab	t	Male	Mens Standard Fit Printed Short Sleeve Poplin Button-Down Shirt	https://target.scene7.com/is/image/Target/GUEST_46ff136f-34ca-4fd6-a934-fe6b26b4fed0?fmt=webp&wid=1400&qlt=80	midSection
51	12.990000	https://www.target.com/p/women-s-jurassic-park-short-sleeve-graphic-t-shirt-black/-/A-80379094?preselect=79761115#lnk=sametab	t	Female	Jurassic Park Short Sleeve Graphic T-Shirt	https://target.scene7.com/is/image/Target/GUEST_cce041cf-a611-4bab-b02a-21ec7478370b?fmt=webp&wid=1400&qlt=80	midSection
52	12.990000	https://www.target.com/p/men-s-maruchan-short-sleeve-graphic-t-shirt-white/-/A-54376610?preselect=54312413#lnk=sametab	t	Unisex	Maruchan Short Sleeve Graphic T-Shirt White	https://target.scene7.com/is/image/Target/GUEST_51b1a274-013b-485c-a266-f4cf61c2cfa5?fmt=webp&wid=1400&qlt=80	midSection
53	15.000000	https://www.target.com/p/girls-long-sleeve-printed-cozy-pullover-cat-jack/-/A-80606156?preselect=79481689#lnk=sametab	f	Female	Long Sleeve Printed Cozy Pullover	https://target.scene7.com/is/image/Target/GUEST_9c8bb6e9-cd2e-4c68-9a64-8d335863e374?fmt=webp&wid=1400&qlt=80	midSection
54	12.990000	https://www.target.com/p/men-s-spongebob-squarepants-singing-spongebob-short-sleeve-graphic-t-shirt-black/-/A-77603052?preselect=77457372#lnk=sametab	t	Unisex	SpongeBob SquarePants Singing SpongeBob Short Sleeve Graphic T-Shirt	https://target.scene7.com/is/image/Target/GUEST_e783c940-4a2b-403e-b81b-4093b37be0c3?fmt=webp&wid=1400&qlt=80	midSection
55	18.000000	https://www.target.com/p/girls-tie-dye-hoodie-more-than-magic-charcoal/-/A-79644951?preselect=79423649#lnk=sametab	f	Female	Tie-Dye Hoodie	https://target.scene7.com/is/image/Target/GUEST_e8bc8c4a-b8fb-4455-b3f6-5eeb2c9c8c7c?fmt=webp&wid=1400&qlt=80	midSection
56	22.990000	https://www.target.com/p/girls-disney-stitch-cosplay-hoodie-blue/-/A-79897412?preselect=79713082#lnk=sametab	f	Female	Disney Stitch Cosplay Hoodie	https://target.scene7.com/is/image/Target/GUEST_d6f4e08c-a6ff-4488-81a5-2c0bd58f4e59?fmt=webp&wid=1400&qlt=80	midSection
57	8.990000	https://www.target.com/p/boys-minecraft-periodic-table-short-sleeve-t-shirt-green/-/A-54243175?preselect=54230708#lnk=sametab	f	Unisex	Minecraft Periodic Table Short Sleeve T-Shirt	https://target.scene7.com/is/image/Target/GUEST_a1b83e0c-920e-469b-a792-f00de0b16e89?fmt=webp&wid=1400&qlt=80	midSection
58	7.000000	https://www.target.com/p/girls-short-sleeve-interlock-uniform-polo-shirt-cat-jack/-/A-79364115?preselect=78774580#lnk=sametab	f	Female	Short Sleeve Interlock Uniform Polo Shirt	https://target.scene7.com/is/image/Target/GUEST_61437527-3629-4874-88cf-e5dcbd2f97fd?fmt=webp&wid=1400&qlt=80	midSection
59	8.990000	https://www.target.com/p/boys-all-my-friends-are-pokemon-short-sleeve-graphic-t-shirt-blue/-/A-53953611?preselect=53932322#lnk=sametab	f	Unisex	All My Friends are Pokemon Short Sleeve T-Shirt	https://target.scene7.com/is/image/Target/GUEST_d4fe68a9-1e10-40f3-b1e8-b1a2c707e628?fmt=webp&wid=1400&qlt=80	midSection
60	19.990000	https://www.target.com/p/boys-star-wars-the-mandalorian-baby-yoda-sweatshirt-beige-green/-/A-79760697?preselect=79659585#lnk=sametab	f	Male	Boys Star Wars The Mandalorian Baby Yoda Sweatshirt	https://target.scene7.com/is/image/Target/GUEST_6f37d79b-520a-439f-85b9-094099e856b1?fmt=webp&wid=1400&qlt=80	midSection
61	240.000000	https://www.target.com/p/mizuno-men-s-wave-prophecy-7-running-shoe/-/A-76111832?preselect=76134519#lnk=sametab	t	Male	Mizuno Mens Wave Prophecy 7 Running Shoe	https://target.scene7.com/is/image/Target/GUEST_964ec0d8-5a2d-455e-8106-82a86e0acc61?fmt=webp&wid=1400&qlt=80	footwear
62	29.990000	https://www.target.com/p/women-s-claudia-short-shearling-style-boots-universal-thread/-/A-79781365?preselect=79705052#lnk=sametab	t	Female	Claudia Short Shearling Style Boots	https://target.scene7.com/is/image/Target/GUEST_414ef866-e4cf-4939-9e44-cd292b4074b7?fmt=webp&wid=1400&qlt=80	footwear
63	29.990000	https://www.target.com/p/women-s-gabriella-mid-heel-platform-pumps-a-new-day/-/A-79582684?preselect=77404348#lnk=sametab	t	Female	Gabriella Mid Heel Platform Pumps	https://target.scene7.com/is/image/Target/GUEST_b17b1850-ba2a-4ad3-b167-8496d44a3b3e?fmt=webp&wid=1400&qlt=80	footwear
64	36.990000	https://www.target.com/p/men-s-benton-oxford-dress-shoes-goodfellow-co/-/A-78133377?preselect=77401132#lnk=sametab	t	Male	Mens Benton Oxford Dress Shoes	https://target.scene7.com/is/image/Target/GUEST_b6a3c696-1c7f-4756-b387-9553d61c8c15?fmt=webp&wid=1400&qlt=80	footwear
65	22.990000	target.com/p/women-s-remmy-backless-loafers-a-new-day-153-black/-/A-53442609?preselect=53383507#lnk=sametab	t	Female	Remmy Backless Loafers	https://target.scene7.com/is/image/Target/GUEST_ecb330f6-00c1-4eca-b43b-c30adf0506b5?fmt=webp&wid=1400&qlt=80	footwear
66	19.990000	https://www.target.com/p/men-s-remington-flip-flop-sandals-goodfellow-co/-/A-78144672?preselect=78308302#lnk=sametab	t	Male	Mens Remington Flip Flop Sandals	https://target.scene7.com/is/image/Target/GUEST_e4d37924-e2ea-4222-ac96-53a36a15fef9?fmt=webp&wid=1400&qlt=80	footwear
67	44.990000	https://www.target.com/p/men-s-jeffrey-cap-toe-combat-boots-goodfellow-co/-/A-79542771?preselect=79481000#lnk=sametab	t	Male	Mens Jeffery Cap Toe Combat Boots	https://target.scene7.com/is/image/Target/GUEST_729b0462-573d-46c3-a7a3-208ecf2722d9?fmt=webp&wid=1400&qlt=80	footwear
68	24.990000	https://www.target.com/p/women-s-maura-mules-universal-thread-153/-/A-54284159?preselect=54264544#lnk=sametab	t	Female	Maura Mules	https://target.scene7.com/is/image/Target/GUEST_bb8caf85-464d-4fdf-96bf-056a115e2b18?fmt=webp&wid=1400&qlt=80	footwear
69	29.990000	https://www.target.com/p/men-s-luther-sneakers-goodfellow-co-white/-/A-78782059?preselect=78308277#lnk=sametab	t	Male	Mens Luther Sneakers	https://target.scene7.com/is/image/Target/GUEST_c044cadc-4950-4005-bd86-7f61e67eb1d1?fmt=webp&wid=1400&qlt=80	footwear
70	21.990000	https://www.target.com/p/men-s-topher-moccasin-slippers-goodfellow-co/-/A-78187174?preselect=53301282#lnk=sametab	t	Male	Mens Topher Moccasin Slippers	https://target.scene7.com/is/image/Target/GUEST_7e8dab6a-59e2-4036-a367-3409cc4f6f21?fmt=webp&wid=1400&qlt=80	footwear
71	160.000000	https://www.target.com/p/mizuno-wave-sky-waveknit-3-women-s-running-shoe/-/A-80310120?preselect=80310145#lnk=sametab	t	Female	Wave Sky Waveknit 3	https://target.scene7.com/is/image/Target/GUEST_a02139e7-1c37-42b1-878f-160c60d0b6ff?fmt=webp&wid=1400&qlt=80	footwear
72	19.990000	https://www.target.com/p/women-s-reese-memory-foam-insole-sneakers-a-new-day/-/A-79607554	t	Female	Reese Memory Foam Insole Sneakers	https://target.scene7.com/is/image/Target/GUEST_b5a13e0b-cecc-4859-9b74-9aa9e98c5392?fmt=webp&wid=1400&qlt=80	footwear
73	34.990000	https://www.target.com/p/boys-s-sport-by-skechers-jaycob-performance-light-up-slip-on-athletic-shoes/-/A-79553990?preselect=79385850#lnk=sametab	f	Male	Boys S Sport by Skechers Jaycob Performance Light Up Slip-On Athletic Shoes	https://target.scene7.com/is/image/Target/GUEST_7e35dd08-0f99-4164-8c88-8fd7aed9dd9d?fmt=webp&wid=1400&qlt=80	footwear
74	29.990000	https://www.target.com/p/kids-jet-power-strap-sneakers-all-in-motion/-/A-79429020?preselect=79181509#lnk=sametab	f	Female	Jet Power Strap Sneakers	https://target.scene7.com/is/image/Target/GUEST_a04877aa-968f-4000-8d99-691fa79b73d6?fmt=webp&wid=1400&qlt=80	footwear
75	34.990000	https://www.target.com/p/kids-dori-winter-boots-all-in-motion-gray/-/A-79777378?preselect=79645430#lnk=sametab	f	Female	Dori Winter Boots	https://target.scene7.com/is/image/Target/GUEST_53685ea9-b424-4202-8a9b-1dee9e52c3d2?fmt=webp&wid=1400&qlt=80	footwear
76	9.990000	https://www.target.com/p/boys-nikko-slip-on-slide-sandals-cat-jack/-/A-77993291?preselect=76675300#lnk=sametab	f	Male	Boys Nikko Slip On Slide Sandals	https://target.scene7.com/is/image/Target/GUEST_2e20bbf3-9b17-46a2-aeee-f12208af6e0b?fmt=webp&wid=1400&qlt=80	footwear
77	19.990000	https://www.target.com/p/girls-mad-love-flynn-slip-on-footbed-sandals/-/A-77599988?preselect=77425238#lnk=sametab	f	Female	Mad Love Flynn Slip-On Footbed Sandals	https://target.scene7.com/is/image/Target/GUEST_6809ce2b-39fa-4c40-97ab-07c6f5130c0d?fmt=webp&wid=1400&qlt=80	footwear
78	14.990000	https://www.target.com/p/girls-indigo-slip-on-ballet-flats-cat-jack-black/-/A-79363764?preselect=78829978#lnk=sametab	f	Female	Indigo Slip-On Ballet Flats	https://target.scene7.com/is/image/Target/GUEST_8a52a233-854a-4c29-b59e-cfda90c9173f?fmt=webp&wid=1400&qlt=80	footwear
79	24.990000	https://www.target.com/p/boys-lucian-sneakers-cat-jack-black/-/A-79295314?preselect=78856592#lnk=sametab	f	Male	Boys Lucian Sneakers	https://target.scene7.com/is/image/Target/GUEST_c4f900ee-a622-45d6-a9e5-d1750d120a2f?fmt=webp&wid=1400&qlt=80	footwear
80	14.990000	https://www.target.com/p/girls-jaime-twin-gore-slip-on-sneakers-cat-jack-153/-/A-54435189?preselect=54345135#lnk=sametab	f	Unisex	Jaime Twin Gore Slip-On Sneakers	https://target.scene7.com/is/image/Target/GUEST_edc7d686-0d5b-442f-a2b0-b23232515bfc?fmt=webp&wid=1400&qlt=80	footwear
81	15.000000	https://www.target.com/p/original-use-8482-men-39-s-surf-shade-sunglasses-black/-/A-50285574#lnk=sametab	t	Unisex	Original Use Mens Surf Shade Sunglasses	https://target.scene7.com/is/image/Target/GUEST_a27ce68c-0fff-4b51-91cd-91bc90f78914?fmt=webp&wid=1400&qlt=80	accessory
82	16.990000	https://www.target.com/p/long-metal-chain-link-necklace-a-new-day-8482-gold/-/A-79694888#lnk=sametab	t	Female	Long Metal Chain Link Necklace	https://target.scene7.com/is/image/Target/GUEST_ce4d0c2e-c93b-4f8d-8677-67f29f643c94?fmt=webp&wid=1400&qlt=80	accessory
83	19.990000	https://www.target.com/p/women-39-s-square-face-watch-a-new-day-8482-light-silver/-/A-79547555#lnk=sametab	t	Female	Square Face Watch	https://target.scene7.com/is/image/Target/GUEST_1d68282d-ad90-42b4-8dcb-c408f83562fa?fmt=webp&wid=1400&qlt=80	accessory
84	45.000000	https://www.target.com/p/bueno-zip-closure-crossbody-bag-black-tan/-/A-80959174#lnk=sametab	t	Female	Bueno Zip Closure Crossbody Bag	https://target.scene7.com/is/image/Target/GUEST_1f9f0e4e-93a2-404e-a1e4-6737e6ce906d?fmt=webp&wid=1400&qlt=80	accessory
85	149.000000	https://www.target.com/p/carrera-33-s-807-pt-Unisex-aviator-sunglasses-black-62mm/-/A-79319399#lnk=sametab	t	Unisex	Carrera Unisex Aviator Sunglasses Black	https://target.scene7.com/is/image/Target/GUEST_c62b79cd-abd3-45c8-bbc4-400c260cb3e0?fmt=webp&wid=1400&qlt=80	accessory
86	16.990000	https://www.target.com/p/endless-beaded-necklace-a-new-day/-/A-79694235?preselect=79586289#lnk=sametab	t	Female	Endless Beaded Necklace	https://target.scene7.com/is/image/Target/GUEST_7797d8a3-553a-4ee7-bc8b-de84a875fa80?fmt=webp&wid=1400&qlt=80	accessory
87	208.000000	https://www.target.com/p/police-flare-1-spl-830-300-Unisex-round-sunglasses-gold-on-black-51mm/-/A-79319381#lnk=sametab	t	Unisex	Police Flare Unisex Round Sunglasses Gold on Black 51mm	https://target.scene7.com/is/image/Target/GUEST_1dd3d581-105b-49d3-989a-1ea571362aff?fmt=webp&wid=1400&qlt=80	accessory
88	45.500000	https://www.target.com/p/women-s-timex-stretch-bangle-watch-silver-tw2r98700jt/-/A-53519304#lnk=sametab	t	Female	Timex Stretch Bangle Watch	https://target.scene7.com/is/image/Target/GUEST_4f60611b-3423-496a-9c33-6d7103370f56?fmt=webp&wid=1400&qlt=80	accessory
89	239.990000	https://www.target.com/p/garmin-v-237-vomove-hr-hybrid-smartwatch/-/A-53920288?preselect=53753920#lnk=sametab	t	Male	Garmin Vivomove HR Hybrid smartwatch	https://target.scene7.com/is/image/Target/GUEST_aaeab8b7-4924-4766-a190-4c588885e214?fmt=webp&wid=1400&qlt=80	accessory
90	34.990000	https://www.target.com/p/estee-38-lilly-floral-print-beaded-envelope-clutch-off-white/-/A-78718420#lnk=sametab	t	Female	Estee & Lilly Floral Print Beaded Envelope Clutch	https://target.scene7.com/is/image/Target/GUEST_ff24b649-c1a3-4d4e-8288-19669a3657d3?fmt=webp&wid=1400&qlt=80	accessory
91	23.990000	https://www.target.com/p/bellwether-balaclava-black-one-size-brushed-fabric-synthetic-wicking/-/A-76784061#lnk=sametab	t	Unisex	Bellweather Balaclava Black One Size Brushed Fabric Synthetic Wicking	https://target.scene7.com/is/image/Target/GUEST_eb178315-3d78-4888-ab96-794abcd4202a?fmt=webp&wid=1400&qlt=80	accessory
92	6.000000	https://www.target.com/p/star-and-moon-necklace-set-wild-fable-8482-gold/-/A-79285493#lnk=sametab	t	Female	Star and Moon Necklace Set	https://target.scene7.com/is/image/Target/GUEST_bc926088-0b15-4cef-9157-40c743964ac3?fmt=webp&wid=1400&qlt=80	accessory
93	65.990000	https://www.target.com/p/men-s-crucible-polished-stainless-steel-flat-byzantine-chain-necklace-10mm-22/-/A-52558448?preselect=52438133#lnk=sametab	t	Male	Mens Crucible Polished Stainless Steel Flat Byzantine Chain Necklace	https://target.scene7.com/is/image/Target/GUEST_db67e75e-fe25-4ad8-8932-e9a3e089a733?fmt=webp&wid=1400&qlt=80	accessory
94	17.000000	https://www.target.com/p/women-39-s-plaid-oversized-square-scarf-universal-thread-8482-metallic-gray/-/A-79653723#lnk=sametab	t	Unisex	Plaid Oversized Square Scarf	https://target.scene7.com/is/image/Target/GUEST_beb68bee-9c2f-4227-8e63-57afb5cd276f?fmt=webp&wid=1400&qlt=80	accessory
95	6.990000	https://www.target.com/p/girls-39-3pk-bracelet-set-more-than-magic-8482/-/A-77555198#lnk=sametab	f	Female	3pk Bracelet Set	https://target.scene7.com/is/image/Target/GUEST_20a7fd91-b383-4bb6-ba78-07f35c0b9b45?fmt=webp&wid=1400&qlt=80	accessory
96	5.990000	https://www.target.com/p/boys-39-surf-sunglasses-cat-38-jack-8482-mint/-/A-77771210#lnk=sametab	f	Unisex	Surf Sunglasses	https://target.scene7.com/is/image/Target/GUEST_9566a612-7934-485d-bb4a-1d22da318b38?fmt=webp&wid=1400&qlt=80	accessory
97	5.990000	https://www.target.com/p/boys-39-minecraft-game-over-gloves-green/-/A-79635479#lnk=sametab	f	Unisex	Minecraft Game Over Gloves - Green	https://target.scene7.com/is/image/Target/GUEST_0b5fc79f-7d2d-4226-9037-3f5c54911c4b?fmt=webp&wid=1400&qlt=80	accessory
98	20.000000	https://www.target.com/p/men-s-plaid-oblong-scarf-goodfellow-co-one-size/-/A-79691411?preselect=79483855#lnk=sametab	f	Unisex	Plaid Oblong Scarf	https://target.scene7.com/is/image/Target/GUEST_23d60431-d6ce-47c2-a67e-365d91173b6d?fmt=webp&wid=1400&qlt=80	accessory
99	7.990000	https://www.target.com/p/boys-pokemon-flashing-lcd-watch-black/-/A-54460833#lnk=sametab	f	Male	Boys Pokemon Flashing LCD Watch	https://target.scene7.com/is/image/Target/GUEST_1adc60c9-62a5-4583-abc3-6ba7887601b3?fmt=webp&wid=1400&qlt=80	accessory
100	42.000000	https://www.target.com/p/meri-meri-knitted-shark-scarf-scarves-christmas-1ct/-/A-78693991#lnk=sametab	f	Unisex	Meri Meri - Knitted Shark Scarf	https://target.scene7.com/is/image/Target/GUEST_06a05a4e-041d-400f-8141-494a83752342?fmt=webp&wid=1400&qlt=80	accessory
101	16.990000	https://www.amazon.com/Carhartt-Mens-Acrylic-Watch-A18/dp/B07QTLNJLV/ref=sr_1_3?dchild=1&keywords=headwear&qid=1606261610&sr=8-3	t	Male	Carhartt Mens Acrylic Watch Hat A18	https://m.media-amazon.com/images/I/91X4ATkyrBL._AC_SX342._SX._UX._SY._UY_.jpg	headwear
122	69.880000	https://www.amazon.com/Five-Ten-Freerider-Womens-Mountain/dp/B07PCSJVFN/ref=sr_1_20?dchild=1&keywords=footwear&qid=1606274926&sr=8-20	t	Female	Five Ten Womens Freerider Bike Shoe	https://m.media-amazon.com/images/I/71Bpctwzm+L._AC_SX395._SX._UX._SY._UY_.jpg	footwear
102	9.950000	https://www.amazon.com/Tough-Headwear-Cable-Knit-Beanie/dp/B01M9DKI30/ref=sxin_9_ac_d_rm?ac_md=6-3-dG91Z2ggaGVhZHdlYXI%3D-ac_d_rm&cv_ct_cx=headwear&dchild=1&keywords=headwear&pd_rd_i=B01M9DKI30&pd_rd_r=f57c6122-646b-43e4-a551-412ff411638a&pd_rd_w=vtmQR&pd_rd_wg=wCbKK&pf_rd_p=b6dc128d-7461-4205-b97b-a956bf7315b7&pf_rd_r=Q2DFQQPFX9MKDTZ47M0G&psc=1&qid=1606261610&sr=1-4-12d4272d-8adb-4121-8624-135149aa9081	t	Female	Tough Headwear Womens Beanie Winter Hat	https://m.media-amazon.com/images/I/71TkI0fCxlL._AC_SY445._SX._UX._SY._UY_.jpg	headwear
103	19.990000	https://www.amazon.com/Carhartt-Mens-Fleece-Headwear-Brown/dp/B002C069M4/ref=sr_1_5?dchild=1&keywords=headwear&qid=1606261610&sr=8-5	t	Male	Carhartt Mens Fleece 2 In 1 Hat	https://m.media-amazon.com/images/I/91sjtu80O7L._AC_SX522._SX._UX._SY._UY_.jpg	headwear
104	4.520000	https://www.amazon.com/Leopard-Headband-Headbands-Hairband-Headwear/dp/B085DDDQLW/ref=sr_1_9?dchild=1&keywords=headwear&qid=1606261610&sr=8-9	t	Female	Leopard Print Headband	https://m.media-amazon.com/images/I/61aj9PPb8GL._SY355_.jpg	headwear
105	12.990000	https://www.amazon.com/Headbands-Fashion-Accessories-Headwear-Hairbands/dp/B07W4PJHKG/ref=sr_1_45?dchild=1&keywords=headwear&qid=1606261610&sr=8-45	t	Female	Padded Headbands Pearl Fashion	https://images-na.ssl-images-amazon.com/images/I/51G2jGlLboL._SY355_.jpg	headwear
106	9.990000	https://www.amazon.com/Headshion-Skull-Cap-Multifunctional-Headwear/dp/B07P1FXRYV/ref=sr_1_2?dchild=1&keywords=men+headwear&qid=1606263222&sr=8-2	t	Unisex	Headshion Skull Cap	https://images-na.ssl-images-amazon.com/images/I/6193SZSbnjL._AC_UX385_.jpg	headwear
107	11.850000	https://www.amazon.com/Headbands-Headband-Wrapped-Anti-slip-Headwear/dp/B087R2YB8K/ref=sr_1_1?dchild=1&keywords=kid+headwear&qid=1606263450&sr=8-1	f	Female	27 Pcs Fabric Headbands DIY	https://images-na.ssl-images-amazon.com/images/I/71cuY5qjbJL._SL1100_.jpg	headwear
108	8.950000	https://www.amazon.com/TOP-HEADWEAR-TopHeadwear-Baseball-Adjustable/dp/B01JKH9HDO/ref=sr_1_7?dchild=1&keywords=kids+headwear&qid=1606264354&sr=8-7	f	Unisex	Top Headwear Blank Kids Youth Baseball Adjustable Hook and Loop Hat	https://images-na.ssl-images-amazon.com/images/I/71o0Odp5AFL._AC_UX466_.jpg	headwear
109	13.980000	https://www.amazon.com/Xinshi-Cotton-Turban-Toddler-Tabbit/dp/B07TWY436S/ref=sr_1_22?dchild=1&keywords=kids+headwear&qid=1606264949&sr=8-22	f	Female	Girls Baby Cotton Cloth Turban Kont Toddler Tabbit Ear Hat	https://images-na.ssl-images-amazon.com/images/I/61mt9hTE22L._AC_UX466_.jpg	headwear
110	8.990000	https://www.amazon.com/Headwear-Childrens-Embroidered-Baseball-Available/dp/B07MTMWDJC/ref=sr_1_47?dchild=1&keywords=kids+headwear&qid=1606264949&sr=8-47	f	Male	R&M Headwear Children Embroidered Monster Truck Baseball Hat/Cap	https://images-na.ssl-images-amazon.com/images/I/91gBlhg7P6L._AC_UX385_.jpg	headwear
111	6.950000	https://www.amazon.com/Daily-Ribbed-Beanie-Tough-Headwear/dp/B01LI3COJM/ref=sr_1_5?dchild=1&keywords=men+headwear&qid=1606265308&sr=8-5	t	Unisex	Winter Beanie Knit Hats for Men & Women	https://images-na.ssl-images-amazon.com/images/I/71uZUR2VPdL._AC_UY445_.jpg	headwear
112	20.910000	https://www.amazon.com/Bluetooth-Novelty-Headwear-Christmas-Stocking/dp/B08BP46G7L/ref=sr_1_17?dchild=1&keywords=men+headwear&qid=1606265426&sr=8-17	f	Unisex	Bluetooth Beanie Novelty Headwear Christmas Stocking Stuffer Gifts for Men Women	https://m.media-amazon.com/images/I/81Gv+8uDHBL._AC_SX342._SX._UX._SY._UY_.jpg	headwear
113	22.500000	https://www.amazon.com/Coal-Trucker-Adjustable-Snapback-Charcoal/dp/B01H2ZXO3U/ref=sr_1_25?dchild=1&keywords=men+headwear&qid=1606265426&sr=8-25	t	Male	Coal Mens The Hauler Mesh Back Trucker Hat Adjustable Snapback Cap	https://m.media-amazon.com/images/I/91rwcQHKYPL._AC_SX425._SX._UX._SY._UY_.jpg	headwear
114	15.990000	https://www.amazon.com/dp/B07CH2718Z/ref=sspa_dk_detail_4?psc=1&pd_rd_i=B07CH2718Z&pd_rd_w=Vymos&pf_rd_p=f0355a48-7e73-489a-9590-564e12837b93&pd_rd_wg=tctaD&pf_rd_r=72K7BV8XQPQFCFEPJK1D&pd_rd_r=217742d4-4e6f-4d22-b6df-b802fbe25896&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExWUc2RVBUQ1oxTDQ3JmVuY3J5cHRlZElkPUEwOTQ1MDA2WlVCVUdONERENkhDJmVuY3J5cHRlZEFkSWQ9QTAxNzU5MDkyRVdPOEhFTFVIOVREJndpZGdldE5hbWU9c3BfZGV0YWlsX3RoZW1hdGljJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Male	FORTREE 2 Pack Multifunction Slouchy Beanie for Jogging, Cycling	https://m.media-amazon.com/images/I/717lqBLTyYL._AC_SX385._SX._UX._SY._UY_.jpg	headwear
115	13.990000	https://www.amazon.com/dp/B07R3WJGGV/ref=sspa_dk_detail_1?psc=1&pd_rd_i=B07R3WJGGV&pd_rd_w=bu6Cw&pf_rd_p=7d37a48b-2b1a-4373-8c1a-bdcc5da66be9&pd_rd_wg=08p4D&pf_rd_r=5G2G8TA08PDN7CHAPSP6&pd_rd_r=e0e4d1aa-4eb7-49af-947f-04c8ff8e4a67&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzT0pMRFdCRU1NTEM1JmVuY3J5cHRlZElkPUEwMjQxNTQ4Mlo5NUxGNElQRTZZVCZlbmNyeXB0ZWRBZElkPUEwMDk5NDQ2Mk1XUERBSkQzSzJDOCZ3aWRnZXROYW1lPXNwX2RldGFpbCZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=	t	Unisex	Empirelion 9" Multifunctional Lightweight Beanies Hats, Running Skull Cap Helmet Liner Sleep Caps for Men Women	https://images-na.ssl-images-amazon.com/images/I/61W32DfJLML._AC_UX569_.jpg	headwear
116	139.990000	https://www.amazon.com/ECCO-Hybrid-Hydromax-Shadow-13-13-5/dp/B07L8Y44QQ/ref=sr_1_5?dchild=1&keywords=footwear&qid=1606266167&s=apparel&sr=1-5	t	Male	ECCO Mens Biom Hybrid Hydromax Golf Shoe	https://images-na.ssl-images-amazon.com/images/I/71icInOICcL._AC_UX500_.jpg	footwear
117	156.250000	https://www.amazon.com/ECCO-Hybrid-Gore-TEX-Leather-12-12-5/dp/B07PZ8P38F/ref=sr_1_6?dchild=1&keywords=footwear&qid=1606266167&s=apparel&sr=1-6	t	Male	ECCO Mens Biom Hybrid 3 Golf Shoe Gore-Tex	https://images-na.ssl-images-amazon.com/images/I/71xzy95QmdL._AC_UX500_.jpg	footwear
118	39.050000	https://www.amazon.com/Kamik-Footwear-Snobuster1-Insulated-Little/dp/B00AZOS0DK/ref=sr_1_7?dchild=1&keywords=footwear&qid=1606266167&s=apparel&sr=1-7	f	Female	Kamik Footwear Kids Snobuster1 Insulated Snow Boot (Toddler/Little Kid/Big Kid)	https://m.media-amazon.com/images/I/61vr-Q+Oh2L._AC_SY395._SX._UX._SY._UY_.jpg	footwear
119	18.390000	https://www.amazon.com/LUCKY-STEP-Sneakers-Non-Slip-Hologram-Carnivals/dp/B07RWB8G9H/ref=sxin_9_sxwds-deals-bau?cv_ct_cx=footwear&dchild=1&keywords=footwear&pd_rd_i=B07RWB8G9H&pd_rd_r=a959d723-2595-463a-a473-686352a1bf22&pd_rd_w=pW4JG&pd_rd_wg=zr5Pg&pf_rd_p=49283211-5eb3-4537-b8c1-8060e9bc3abc&pf_rd_r=DK2H4T1MS83SSM0BKYWG&psc=1&qid=1606274450&sr=1-3-532c9ed3-585f-4779-b9c7-067a76a25fad	t	Female	LUCKY-STEP Women Fashion Clear Sole Sequins Sneakers Casual Lace Up Sports Walking Shoes	https://images-na.ssl-images-amazon.com/images/I/61vS7kuX6aL._AC_UX500_.jpg	footwear
120	48.000000	https://www.amazon.com/Columbia-Redmond-Hiking-Pebble-Regular/dp/B07JHCGT41/ref=sr_1_2?dchild=1&keywords=footwear&qid=1606274450&sr=8-2	t	Male	Columbia Mens Redmond V2 Hiking Shoe	https://m.media-amazon.com/images/I/8162xh1ojLL._AC_SX395._SX._UX._SY._UY_.jpg	footwear
121	41.940000	https://www.amazon.com/Under-Armour-Charged-Assert-Running/dp/B07G7H4G9S/ref=sr_1_3?dchild=1&keywords=footwear&qid=1606274450&sr=8-3	t	Male	Under Armour Mens Charged Assert 8 Running Shoe	https://m.media-amazon.com/images/I/716oJ-B9WOL._AC_SX395._SX._UX._SY._UY_.jpg	footwear
198	26.000000	https://trippnyc.com/product/is5030-blk/	t	Unisex	PIERCING FACE COVER	https://trippnyc.com/wp-content/uploads/2020/10/IS5030_BLK_F.jpg	accessory
123	42.990000	https://www.amazon.com/Wonesion-Breathable-Running-Athletic-Sneakers/dp/B087CVF72C/ref=sr_1_14_sspa?dchild=1&keywords=footwear&qid=1606274926&sr=8-14-spons&psc=1&smid=AFNZTRVPU00GC&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFDNFBFSzlKUUszNTEmZW5jcnlwdGVkSWQ9QTA5NDQyNzUyTktNSEZTOUk4UjJVJmVuY3J5cHRlZEFkSWQ9QTA1MjU4ODYzSFk4TTY5MVZXVE1WJndpZGdldE5hbWU9c3BfbXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Female	Wonesion Womens Walking Running Shoes Athletic Blade Non Slip Tennis Fashion Sneakers	https://images-na.ssl-images-amazon.com/images/I/81%2BqbrrTzbL._AC_UX500_.jpg	footwear
124	19.150000	https://www.amazon.com/Crocs-Unisex-Classic-Toddlers-Sandal/dp/B07N88X4DT/ref=sr_1_2?dchild=1&keywords=kids+footwear&qid=1606275373&sr=8-2	f	Unisex	Crocs Kids Classic Clog | Slip On Shoes for Boys and Girls | Water Shoes	https://images-na.ssl-images-amazon.com/images/I/61RX1femUjL._AC_UX500_.jpg	footwear
125	29.990000	https://www.amazon.com/UBFEN-Running-Shoes-Sneakers-Orange/dp/B08KPDJ7DN/ref=sr_1_1_sspa?dchild=1&keywords=kids+footwear&qid=1606275373&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzQkRBQkRWOFcxRFFCJmVuY3J5cHRlZElkPUEwOTgzNzAwMjgxV1FITUVOU0FXViZlbmNyeXB0ZWRBZElkPUEwNTE3NDA0M0c0V0dLVldJS1oxMyZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=	f	Unisex	UBFEN Kids Running Shoes Sneakers for Boys Girls	https://images-na.ssl-images-amazon.com/images/I/81zTlY7ewEL._AC_UX395_.jpg	footwear
126	39.060000	https://www.amazon.com/Kamik-Footwear-Snobuster1-Insulated-Little/dp/B00AZOS0DK/ref=sr_1_3?dchild=1&keywords=kids+footwear&qid=1606275373&sr=8-3	f	Female	Kamik Footwear Kids Snobuster1 Insulated Snow Boot (Toddler/Little Kid/Big Kid)	https://images-na.ssl-images-amazon.com/images/I/71P1jJEGA1L._AC_UY395_.jpg	footwear
127	55.000000	https://www.amazon.com/Heelys-Wheeled-Footwear-Skate-White/dp/B08279K9FN/ref=sr_1_5?dchild=1&keywords=kids+footwear&qid=1606275373&sr=8-5	f	Male	Heelys Kids Wheeled Footwear Skate Shoe	https://images-na.ssl-images-amazon.com/images/I/81luOH-CeXL._AC_UY575_.jpg	footwear
128	49.950000	https://www.amazon.com/BILLY-Footwear-Kids-Classic-Toddler/dp/B07PKWR8WX/ref=sr_1_6?dchild=1&keywords=kids+footwear&qid=1606275373&sr=8-6	f	Female	BILLY Footwear Kids Baby Girls Classic Lace High (Toddler)	https://images-na.ssl-images-amazon.com/images/I/71CweFbEfgL._AC_UX500_.jpg	footwear
129	24.990000	https://www.amazon.com/OTU-Lightweight-Sneaker-Breathable-Darkgrey/dp/B08FY5L5GH/ref=sr_1_29_sspa?dchild=1&keywords=footwear&qid=1606274926&sr=8-29-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFDNFBFSzlKUUszNTEmZW5jcnlwdGVkSWQ9QTA5NDQyNzUyTktNSEZTOUk4UjJVJmVuY3J5cHRlZEFkSWQ9QTAxNDYxMzgzUTNWWTVQV0ZUM1pDJndpZGdldE5hbWU9c3BfbXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Male	OTU Mens Lightweight Sneaker Walking Shoes Breathable Road Running Shoes	https://images-na.ssl-images-amazon.com/images/I/71M9RxJxb3L._AC_UX500_.jpg	footwear
130	25.990000	https://www.amazon.com/VOSTEY-Sneakers-Athletic-Lightweight-Breathable/dp/B07Z3H2W74/ref=sr_1_30_sspa?dchild=1&keywords=footwear&qid=1606274926&sr=8-30-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFDNFBFSzlKUUszNTEmZW5jcnlwdGVkSWQ9QTA5NDQyNzUyTktNSEZTOUk4UjJVJmVuY3J5cHRlZEFkSWQ9QTA0NDQ5NTQxQjFBTzJYODVNVThaJndpZGdldE5hbWU9c3BfbXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Male	VOSTEY Mens Running Shoes Running Sneakers Lightweight Athletic Tennis Walking Running Shoes Breathable Casual	https://images-na.ssl-images-amazon.com/images/I/91Zgwm8QFVL._AC_UX395_.jpg	footwear
131	32.990000	https://www.amazon.com/Actloe-Casual-Sleeve-Printed-Pullover/dp/B08F7HC42L/ref=sr_1_1_sspa?dchild=1&keywords=shirts&qid=1606277540&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyNlU1Ukg1TzRNM1dDJmVuY3J5cHRlZElkPUEwNDUyMDU1MUNXNDA1SEUzNkZMMSZlbmNyeXB0ZWRBZElkPUEwMzk1Njk5M1FUQ05OODBMWTA2ViZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=	t	Female	Actloe Women Tie Dye Sweatshirt Casual Top Long Sleeve Ombre Printed Shirts Color Block Pullovers	https://m.media-amazon.com/images/I/61uaAI1ZXrL._AC_SY445._SX._UX._SY._UY_.jpg	midSection
132	9.990000	https://www.amazon.com/Cotton-Life-T-Shirt-Tshirt-Sleeve/dp/B08FDT7R7Z/ref=sr_1_2_sspa?dchild=1&keywords=shirts&qid=1606277540&sr=8-2-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyNlU1Ukg1TzRNM1dDJmVuY3J5cHRlZElkPUEwNDUyMDU1MUNXNDA1SEUzNkZMMSZlbmNyeXB0ZWRBZElkPUEwNDkwNTM3MUFMSkRYT0FPSjRWQiZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=	t	Male	Cotton For Life T-Shirt - 100% Made in Egypt - 100% Cotton - Crew T-Shirt - Basic Short Sleeve T-Shirt	https://images-na.ssl-images-amazon.com/images/I/91q00F-IH8L._AC_UY445_.jpg	midSection
133	13.000000	https://www.amazon.com/Carhartt-Workwear-Pocket-Short-Sleeve-T-Shirt/dp/B0000ANHT7/ref=sr_1_8?dchild=1&keywords=shirts&qid=1606277540&sr=8-8	t	Male	Carhartt Mens K87 Workwear Pocket Short Sleeve T-Shirt (Regular and Big & Tall Sizes)	https://images-na.ssl-images-amazon.com/images/I/81157f2TGLL._AC_UX342_.jpg	midSection
134	10.000000	https://www.amazon.com/Champion-Classic-Jersey-Script-T-Shirt/dp/B07DJBKRZ1/ref=sr_1_9?dchild=1&keywords=shirts&qid=1606277540&sr=8-9	t	Male	Champion Mens Classic Jersey Script T-Shirt	https://images-na.ssl-images-amazon.com/images/I/71Owur1oEQL._AC_UX342_.jpg	midSection
135	9.970000	https://www.amazon.com/Hanes-Long-Sleeve-Beefy-Henley-T-Shirt/dp/B010276VT4/ref=sr_1_11?dchild=1&keywords=shirts&qid=1606277540&sr=8-11	t	Male	Hanes Mens Long Sleeve Beefy Henley Shirt	https://images-na.ssl-images-amazon.com/images/I/91qfWr5MVqL._AC_UX342_.jpg	midSection
136	29.990000	https://www.amazon.com/Tommy-Hilfiger-Sleeve-Classic-X-Large/dp/B07T6FK27S/ref=sr_1_18?dchild=1&keywords=shirts&qid=1606277540&sr=8-18	t	Male	Tommy Hilfiger Mens Long Sleeve Polo Shirt in Classic Fit	https://images-na.ssl-images-amazon.com/images/I/81WDd82ipHL._AC_UX522_.jpg	midSection
137	8.990000	https://www.amazon.com/Hanes-Womens-Sport-Performance-Sleeve/dp/B01M20UCN8/ref=sr_1_3?dchild=1&keywords=women+shirts&qid=1606278179&sr=8-3	t	Female	Hanes Sport Womens Cool DRI Performance Long Sleeve Tee	https://m.media-amazon.com/images/I/81jGHC0m+nL._AC_SX342._SX._UX._SY._UY_.jpg	midSection
138	19.680000	https://www.amazon.com/YSYOKOW-Womens-Casual-Blouses-Pockets/dp/B08GC5WW5K/ref=sr_1_2_sspa?dchild=1&keywords=women+shirts&qid=1606278179&sr=8-2-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFBMVBBVUdVNk4zVkwmZW5jcnlwdGVkSWQ9QTA3MjQ3NzExWTgxTzAyVkg3OFZMJmVuY3J5cHRlZEFkSWQ9QTAzNjU1OTBSV1kxTlhCVzJNSlkmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl	t	Female	YSYOKOW Womens Casual Loose Shirts Long Sleeve Blouses Tunic Tops with Pockets	https://images-na.ssl-images-amazon.com/images/I/71X-Y86hGQL._AC_UY445_.jpg	midSection
156	18.990000	https://www.amazon.com/Cotton-Active-Sports-Jogger-Little/dp/B074N3DKSW/ref=sr_1_1_sspa?dchild=1&keywords=kid+pants&qid=1606279938&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzREtKSjI5S1BCNldJJmVuY3J5cHRlZElkPUEwMDQ3MzY3MkZCOUJBTEM3VUlPOCZlbmNyeXB0ZWRBZElkPUEwMTUxMjk5UEhMRlc4NE9GS1FFJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	f	Male	BINPAW Boys Cotton Sweatpants, Age 4T-14 (4-14 Years)	https://images-na.ssl-images-amazon.com/images/I/61Cgc5ehf5L._AC_UY741_.jpg	lowerSection
157	18.000000	https://www.amazon.com/adidas-Boys-Jogger-Pant-Black/dp/B07B8HYGXW/ref=sr_1_2?dchild=1&keywords=kid+pants&qid=1606279938&sr=8-2	f	Male	adidas Boys Tricot Jogger Pant	https://images-na.ssl-images-amazon.com/images/I/71DrdZ9HlhL._AC_UY606_.jpg	lowerSection
139	19.980000	https://www.amazon.com/Floral-Find-Womens-Sleeve-Leopard/dp/B07QM7QJ79/ref=sxin_9?ascsubtag=amzn1.osa.285d4a87-9b92-4fe8-8721-946eeddf9ac0.ATVPDKIKX0DER.en_US&creativeASIN=B07QM7QJ79&cv_ct_cx=women+shirts&cv_ct_id=amzn1.osa.285d4a87-9b92-4fe8-8721-946eeddf9ac0.ATVPDKIKX0DER.en_US&cv_ct_pg=search&cv_ct_we=asin&cv_ct_wn=osp-single-source-gl-ranking&dchild=1&keywords=women+shirts&linkCode=oas&pd_rd_i=B07QM7QJ79&pd_rd_r=bb12c2cd-adf3-49f7-a57c-05c868507e3a&pd_rd_w=K4dpn&pd_rd_wg=YhDDF&pf_rd_p=f78282ee-db56-4d41-99a2-17abf93837bc&pf_rd_r=CM2FM4PQTXBQYBA7GM5R&psc=1&qid=1606278179&sr=1-1-d9dc7690-f7e1-44eb-ad06-aebbef559a37&tag=workingmotherbonnier_os-20	t	Female	Floral Find Womens Long Sleeve Leopard Color Block Tunic Comfy Stripe Round Neck T Shirt Tops	https://images-na.ssl-images-amazon.com/images/I/61A-ioPKoqL._AC_UY445_.jpg	midSection
140	22.990000	https://www.amazon.com/Astylish-Women-Button-Sleeves-Blouse/dp/B07G4BD824/ref=sxin_9?ascsubtag=amzn1.osa.285d4a87-9b92-4fe8-8721-946eeddf9ac0.ATVPDKIKX0DER.en_US&creativeASIN=B07G4BD824&cv_ct_cx=women+shirts&cv_ct_id=amzn1.osa.285d4a87-9b92-4fe8-8721-946eeddf9ac0.ATVPDKIKX0DER.en_US&cv_ct_pg=search&cv_ct_we=asin&cv_ct_wn=osp-single-source-gl-ranking&dchild=1&keywords=women+shirts&linkCode=oas&pd_rd_i=B07G4BD824&pd_rd_r=bb12c2cd-adf3-49f7-a57c-05c868507e3a&pd_rd_w=K4dpn&pd_rd_wg=YhDDF&pf_rd_p=f78282ee-db56-4d41-99a2-17abf93837bc&pf_rd_r=CM2FM4PQTXBQYBA7GM5R&psc=1&qid=1606278179&sr=1-2-d9dc7690-f7e1-44eb-ad06-aebbef559a37&tag=workingmotherbonnier_os-20	t	Female	Astylish Women V Neck Striped Roll up Sleeve Button Down Blouses Tops	https://images-na.ssl-images-amazon.com/images/I/61bCK51yknL._AC_UY445_.jpg	midSection
141	18.980000	https://www.amazon.com/Yidarton-Womens-Casual-Sleeve-Knotted/dp/B07J5CK29N/ref=sr_1_6?dchild=1&keywords=women+shirts&qid=1606278179&sr=8-6	t	Female	Yidarton Womens Comfy Casual Twist Knot Tunics Tops Blouses Tshirts	https://images-na.ssl-images-amazon.com/images/I/7195JDf98CL._AC_UX342_.jpg	midSection
142	14.010000	https://www.amazon.com/Lucky-Brand-Girls-Front-Serita/dp/B081T1RNLL/ref=sxin_9_sxwds-deals-bau?cv_ct_cx=kids+shirts&dchild=1&keywords=kids+shirts&pd_rd_i=B081T1RNLL&pd_rd_r=4cf60f6b-f44a-4d74-ba34-bd92e574d162&pd_rd_w=76jCb&pd_rd_wg=vQjbG&pf_rd_p=49283211-5eb3-4537-b8c1-8060e9bc3abc&pf_rd_r=0PDBD6GM2QDX43C80B2Z&psc=1&qid=1606278657&sr=1-2-532c9ed3-585f-4779-b9c7-067a76a25fad	f	Female	Girls Tie Front Knot Tee Shirt	https://images-na.ssl-images-amazon.com/images/I/71%2BZyU5hMbL._AC_UX425_.jpg	midSection
143	13.740000	https://www.amazon.com/LUOUSE-Toddler-Unisex-T-Shirts-Athletic/dp/B08CDHL9ZY/ref=sxin_9_sxwds-deals-bau?cv_ct_cx=kids+shirts&dchild=1&keywords=kids+shirts&pd_rd_i=B08CDHL9ZY&pd_rd_r=4cf60f6b-f44a-4d74-ba34-bd92e574d162&pd_rd_w=76jCb&pd_rd_wg=vQjbG&pf_rd_p=49283211-5eb3-4537-b8c1-8060e9bc3abc&pf_rd_r=0PDBD6GM2QDX43C80B2Z&psc=1&qid=1606278657&sr=1-3-532c9ed3-585f-4779-b9c7-067a76a25fad	f	Female	LUOUSE Toddler Girls Casual Cotton Round Neck Short Sleeve T-Shirts Tee 2-Pack (3T - 12T)	https://images-na.ssl-images-amazon.com/images/I/51VWeHc-lTL._AC_UX385_.jpg	midSection
144	25.700000	https://www.amazon.com/Spotted-Zebra-4-Pack-Long-Sleeve-T-Shirts/dp/B07197Q28R/ref=sr_1_1_sspa?dchild=1&keywords=kids+shirts&qid=1606278657&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFUQUNKVjlDN0E4VkUmZW5jcnlwdGVkSWQ9QTA5NDg5NTQyU1VOTVlaQTNKRFk5JmVuY3J5cHRlZEFkSWQ9QTA5MTY0NjhNMjk5NkFMRURLSFEmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl	f	Male	Spotted Zebra Boys Long-Sleeve T-Shirts	https://images-na.ssl-images-amazon.com/images/I/91Y5uXJMOIL._AC_UX385_.jpg	midSection
145	8.950000	https://www.amazon.com/Fruit-Loom-Cotton-White-Shirt/dp/B079994TMJ/ref=sr_1_3?dchild=1&keywords=kids+shirts&qid=1606278657&sr=8-3	f	Male	Fruit of the Loom Boys Cotton White T Shirt	https://images-na.ssl-images-amazon.com/images/I/614D7dpH9QL._AC_UY445_.jpg	midSection
146	13.430000	https://www.amazon.com/Southpole-Active-Heather-Charcoal-X-Large/dp/B07BRDRGGK/ref=sr_1_1?dchild=1&keywords=pants&qid=1606278954&sr=8-1	t	Male	Southpole Mens Active Basic Jogger Fleece Pants	https://images-na.ssl-images-amazon.com/images/I/81Cmz0EnsSL._AC_UX342_.jpg	lowerSection
147	29.980000	https://www.amazon.com/CQR-Tactical-Repellent-Ripstop-Lightweight/dp/B08JG2XSB7/ref=sr_1_2?dchild=1&keywords=pants&qid=1606278954&sr=8-2	t	Male	CQR Mens Tactical Pants, Water Repellent Ripstop Cargo Pants, Lightweight EDC Hiking Work Pants, Outdoor Apparel	https://images-na.ssl-images-amazon.com/images/I/61CPPBuZwcL._AC_UY445_.jpg	lowerSection
148	17.770000	https://www.amazon.com/Dockers-Classic-Khaki-Pants-Stretch/dp/B01MSANU4B/ref=sr_1_3?dchild=1&keywords=pants&qid=1606278954&sr=8-3	t	Male	Dockers Mens Classic Fit Easy Khaki Pants	https://images-na.ssl-images-amazon.com/images/I/81KUvNkzlQL._AC_UX342_.jpg	lowerSection
149	30.390000	https://www.amazon.com/Under-Armour-Rival-Fleece-Heather/dp/B07YXN3JYF/ref=sr_1_4?dchild=1&keywords=pants&qid=1606278954&sr=8-4	t	Male	Under Armour Mens Rival Fleece Pants	https://images-na.ssl-images-amazon.com/images/I/61mcY4DHZdL._AC_UX385_.jpg	lowerSection
150	26.990000	https://www.amazon.com/Wrangler-Authentics-Fleece-Carpenter-Autumn/dp/B00XKY31CM/ref=sr_1_10?dchild=1&keywords=pants&qid=1606278954&sr=8-10	t	Male	Wrangler Authentics Mens Fleece Lined Carpenter Pant	https://images-na.ssl-images-amazon.com/images/I/81vk0HLeznL._AC_UX342_.jpg	lowerSection
151	28.500000	https://www.amazon.com/Amazon-Essentials-Brushed-Stretch-Spacedye/dp/B07FK7TVM9/ref=sr_1_1_sspa?dchild=1&keywords=women+pants&qid=1606279566&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzS01USE0zNlBBNFlOJmVuY3J5cHRlZElkPUEwNDc0NTk4MldZRk1BNlRDQTFOTSZlbmNyeXB0ZWRBZElkPUEwNDY3NTU3N1VJVDBYTVBRS0gyJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Female	Amazon Essentials Womens Brushed Tech Stretch Crop Jogger Pant	https://images-na.ssl-images-amazon.com/images/I/71vlDOUEleL._AC_UX342_.jpg	lowerSection
152	9.080000	https://www.amazon.com/Gloria-Vanderbilt-Womens-Classic-Average/dp/B000NZTPMQ/ref=sr_1_3?dchild=1&keywords=women+pants&qid=1606279566&sr=8-3	t	Female	Gloria Vanderbilt Womens Classic Amanda GLORIA VANDERBILT High Rise Tapered Jean Pants	https://images-na.ssl-images-amazon.com/images/I/81GLtNTZbPL._AC_UX342_.jpg	lowerSection
153	6.890000	https://www.amazon.com/Hanes-Womens-Middle-Sweatpant-Heather/dp/B0169P8TGQ/ref=sr_1_5?dchild=1&keywords=women+pants&qid=1606279566&sr=8-5	t	Female	Hanes Women’s EcoSmart Sweatpant – Regular and Petite Lengths	https://images-na.ssl-images-amazon.com/images/I/81eJstfdhvL._AC_UX342_.jpg	lowerSection
154	19.950000	https://www.amazon.com/IUGA-Bootcut-Pockets-Workout-Bootleg/dp/B07N1LWCF5/ref=sr_1_6?dchild=1&keywords=women+pants&qid=1606279566&sr=8-6	t	Female	UGA Bootcut Yoga Pants with Pockets for Women High Waist Workout Bootleg Pants Tummy Control, 4 Pockets Work Pants for Women	https://images-na.ssl-images-amazon.com/images/I/61tqyuSjzxL._AC_UY445_.jpg	lowerSection
155	27.000000	https://www.amazon.com/Amazon-Essentials-Womens-Bi-Stretch-Regular/dp/B07BJ8J83R/ref=sxin_10_pb?cv_ct_cx=women+pants&dchild=1&keywords=women+pants&pd_rd_i=B07BJ8J83R&pd_rd_r=c9c8b97d-6d67-412b-ac3b-3c9a2def6033&pd_rd_w=VKTPJ&pd_rd_wg=0NhTM&pf_rd_p=ffb450f7-bfad-4e7e-95e8-f2bd147e99a4&pf_rd_r=SYVP0E1PB5FCG81E0902&psc=1&qid=1606279566&sr=1-2-8065ff8c-2587-4a7f-b8da-1df8b2563c11	t	Female	Amazon Essentials Womens Skinny Pant	https://images-na.ssl-images-amazon.com/images/I/71hc3g0RYkL._AC_UX342_.jpg	lowerSection
158	17.970000	https://www.amazon.com/adidas-Little-Tricot-Iconic-Collegiate/dp/B077JB2YK5/ref=sr_1_3?dchild=1&keywords=kid+pants&qid=1606279938&sr=8-3	f	Male	adidas Boys Tricot Pant	https://images-na.ssl-images-amazon.com/images/I/71rwybdf4fL._AC_UY606_.jpg	lowerSection
159	11.770000	https://www.amazon.com/Kid-Nation-French-Sweatpants-Camouflage/dp/B07W7RY52V/ref=sxin_9_sxwds-deals-bau?cv_ct_cx=kid+pants&dchild=1&keywords=kid+pants&pd_rd_i=B07W7RY52V&pd_rd_r=796aa72d-db33-49f2-8033-4ccaab23bb45&pd_rd_w=GOmUI&pd_rd_wg=RZC6L&pf_rd_p=49283211-5eb3-4537-b8c1-8060e9bc3abc&pf_rd_r=4YQADKG2G7VSA6AH9RM4&psc=1&qid=1606279938&sr=1-1-532c9ed3-585f-4779-b9c7-067a76a25fad	f	Unisex	Kid Nation Kids Unisex Casual Sweatpants Pull On Jogger Pants with Pockets for Boys and Girls 4-12 Years	https://images-na.ssl-images-amazon.com/images/I/91p9PQTLl3L._AC_UY741_.jpg	lowerSection
160	23.990000	https://www.amazon.com/Star-Ride-Sweatpants-Athletic-Grey-Pink-Navy/dp/B08DH9S5MR/ref=sr_1_17?dchild=1&keywords=kid+pants&qid=1606279938&sr=8-17	f	Female	Star Ride Girls 3-Pack Fleece Active Jogger Sweatpants Kids Clothes for Athletic Fashion and Casual Wear	https://images-na.ssl-images-amazon.com/images/I/71hdT7e8eVL._AC_UX342_.jpg	lowerSection
161	39.000000	https://www.amazon.com/Soperwillton-Fashion-Handbags-Shoulder-Satchel/dp/B083QFMFXJ/ref=sr_1_2_sspa?dchild=1&keywords=purses&qid=1606280513&sr=8-2-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFZRDhSWlVHTTVLMTUmZW5jcnlwdGVkSWQ9QTA5ODQ3NTU0VkNPT1gwTkw2NDYmZW5jcnlwdGVkQWRJZD1BMDgwODc1MDNPMTlFMDJWV0lESUwmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl	t	Female	Soperwillton Handbag for Women Shoulder Bags Satchel Tote Bag 5pcs Purse Set	https://images-na.ssl-images-amazon.com/images/I/81H4zOGHa3L._AC_UX500_.jpg	accessory
162	39.990000	https://www.amazon.com/Handbags-Women-Shoulder-Satchel-Purse/dp/B07DCM378H/ref=sr_1_3?dchild=1&keywords=purses&qid=1606280513&sr=8-3	t	Female	Handbags for Women Fashion Tote Bags Shoulder Bag Top Handle Satchel Purse Set 3pcs	https://images-na.ssl-images-amazon.com/images/I/811TwM0O8yL._AC_UY500_.jpg	accessory
163	88.980000	https://www.amazon.com/Michael-Kors-Crossbody-Saffiano-Blosssom/dp/B0811MLVCQ/ref=sr_1_5?dchild=1&keywords=purses&qid=1606280513&sr=8-5	t	Female	Michael Kors Emmy Saffiano Leather Medium Crossbody Bag	https://images-na.ssl-images-amazon.com/images/I/81jXOYWR3rL._AC_UX500_.jpg	accessory
164	42.990000	https://www.amazon.com/Designer-Handbags-Satchel-Shoulder-Matching/dp/B01N19YXAU/ref=sr_1_8?dchild=1&keywords=purses&qid=1606280513&sr=8-8	t	Female	DASEIN Women Handbags Top Handle Satchel Purse Shoulder Bag Briefcase Hobo Bag Set 2pcs	https://images-na.ssl-images-amazon.com/images/I/81dVpanGSeL._AC_UY500_.jpg	accessory
165	39.990000	https://www.amazon.com/Concealed-Studded-Crossbody-Shoulder-Handbags/dp/B0811H1LRZ/ref=sr_1_12?dchild=1&keywords=purses&qid=1606280513&sr=8-12	t	Female	Large Concealed Carry Leather Hobo Purse For Women With Crossbody Strap And Detachable Holster	https://images-na.ssl-images-amazon.com/images/I/81hQz%2BEQ0WL._AC_UY395_.jpg	accessory
166	14.590000	https://www.amazon.com/OSOCE-Shoulder-Crossbody-Adjustable-Messenger/dp/B089WG88XC/ref=sr_1_1_sspa?dchild=1&keywords=men+purse&qid=1606280897&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExRlBOVTVBS0ZPTU83JmVuY3J5cHRlZElkPUEwMjEyMzI1MUFJTkpUTVNCTTRURiZlbmNyeXB0ZWRBZElkPUEwMzI1NDkxMkxaUVk3UjJFVlNDTSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=	t	Unisex	OSOCE Shoulder Bag, Crossbody Bags with Adjustable Strap, Messenger Bag with Zipper Handbag Purse for Men and Women	https://images-na.ssl-images-amazon.com/images/I/61jC4bavcYL._AC_UX466_.jpg	accessory
167	17.990000	https://www.amazon.com/Nautica-Small-Crossbody-black-Size/dp/B07QFFM3V5/ref=sr_1_3?dchild=1&keywords=men+purse&qid=1606280897&sr=8-3	t	Male	Nautica Small Crossbody Bag for Men	https://images-na.ssl-images-amazon.com/images/I/91daDC3agGL._AC_UY500_.jpg	accessory
168	28.030000	https://www.amazon.com/Watches-Chronograph-Stainless-Waterproof-Business/dp/B07Z62B354/ref=sr_1_2_sspa?dchild=1&keywords=men+watches&qid=1606281173&sr=8-2-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFOTTVBODVOMFpRMTYmZW5jcnlwdGVkSWQ9QTA4NDExMDQxRlE3R0dHMllDTVhIJmVuY3J5cHRlZEFkSWQ9QTA4OTg0MjAzR1ZVMUI5TkZESUQwJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Male	Mens Watches Chronograph Stainless Steel Waterproof Date Analog Quartz Fashion Business Wrist Watches for Men	https://images-na.ssl-images-amazon.com/images/I/71VjM5LOeYL._AC_UX679_.jpg	accessory
169	32.980000	https://www.amazon.com/Watches-BENAYR-Chronograph-Waterproof-Business/dp/B07ZRCJH85/ref=sr_1_3_sspa?dchild=1&keywords=men+watches&qid=1606281173&sr=8-3-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFOTTVBODVOMFpRMTYmZW5jcnlwdGVkSWQ9QTA4NDExMDQxRlE3R0dHMllDTVhIJmVuY3J5cHRlZEFkSWQ9QTA0Nzk4NjUyQkZCQk5BSlpaRURHJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	t	Male	Mens Watches BENAYR Casual Chronograph Analog Quartz Waterproof Sports Watches Rubber Strap Business Wrist Watches for Men	https://images-na.ssl-images-amazon.com/images/I/61TzZRRULXL._AC_UX466_.jpg	accessory
170	64.500000	https://www.amazon.com/Fossil-Quartz-Stainless-Leather-Chronograph/dp/B00AFTTQ8I/ref=sr_1_5?dchild=1&keywords=men+watches&qid=1606281173&sr=8-5	t	Male	Fossil Mens Grant Stainless Steel Chronograph Quartz Watch	https://images-na.ssl-images-amazon.com/images/I/81Jt7Y9KHUL._AC_UX466_.jpg	accessory
171	11.990000	https://www.amazon.com/SUNMALL-36-Adjustable-Children-Jewelry/dp/B07HCJ9WW1/ref=sr_1_1_sspa?dchild=1&keywords=kids+jewelry&qid=1606281387&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyUUlNNzMwNEZBQU1QJmVuY3J5cHRlZElkPUEwMTM0MjUwMlVVMjFISlc5WVBaOSZlbmNyeXB0ZWRBZElkPUEwODU5MDg2UjFPWlZIMjlYS01LJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==	f	Female	SUNMALL 36 pcs Little Girl Adjustable Rings in Box	https://m.media-amazon.com/images/I/715x9pL8KPL._AC_UL480_FMwebp_QL65_.jpg	accessory
172	9.980000	https://www.amazon.com/Lorfancy-Bracelets-Bracelet-Multicolor-Friendship/dp/B07TB6G6YN/ref=sxin_9_ac_d_rm?ac_md=1-1-a2lkcyBqZXdlbHJ5IGZvciBnaXJscw%3D%3D-ac_d_rm&cv_ct_cx=kids+jewelry&dchild=1&keywords=kids+jewelry&pd_rd_i=B07TB6G6YN&pd_rd_r=cb32e904-1b65-4b79-a872-a14c06fafb5e&pd_rd_w=EekJc&pd_rd_wg=gKWzI&pf_rd_p=b6dc128d-7461-4205-b97b-a956bf7315b7&pf_rd_r=DZYCY4CK15SBVQSKJX63&psc=1&qid=1606281387&sr=1-2-12d4272d-8adb-4121-8624-135149aa9081	f	Female	Lorfancy 12 Pcs Kids Girls Women Bracelets Jewelry Animal	https://m.media-amazon.com/images/I/71Z2cMRX7gL._AC_UL480_FMwebp_QL65_.jpg	accessory
173	17.990000	https://www.amazon.com/G-C-Princess-Necklace-Bracelet-Colorful/dp/B086C57WNK/ref=sxin_9_ac_d_rm?ac_md=0-0-a2lkcyBqZXdlbHJ5-ac_d_rm&cv_ct_cx=kids+jewelry&dchild=1&keywords=kids+jewelry&pd_rd_i=B086C57WNK&pd_rd_r=cb32e904-1b65-4b79-a872-a14c06fafb5e&pd_rd_w=EekJc&pd_rd_wg=gKWzI&pf_rd_p=b6dc128d-7461-4205-b97b-a956bf7315b7&pf_rd_r=DZYCY4CK15SBVQSKJX63&psc=1&qid=1606281387&sr=1-1-12d4272d-8adb-4121-8624-135149aa9081	f	Female	G.C 3 Sets Girl Princess Necklace Bracelet	https://m.media-amazon.com/images/I/71MpX-qF7KL._AC_UL480_FMwebp_QL65_.jpg	accessory
197	41.560000	https://www.pacsun.com/pacsun/artwork-all-over-hoodie-0193522800048.html?dwvar_0193522800048_color=010&cgid=mens-hoodies-fleece	t	Male	PacSun Artwork All Over Hoodie	https://www.pacsun.com/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dwa76fb34a/product_images/0193522800048NEW_00_010.jpg?sw=690&sh=1070&sm=fit	midSection
174	9.990000	https://www.amazon.com/Blue-Light-Blocking-Glasses-Kids/dp/B083NWZH4C/ref=sr_1_3_sspa?dchild=1&keywords=kids+glasses&qid=1606281644&sr=8-3-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyRkMwRUpRSkFXTFg1JmVuY3J5cHRlZElkPUEwODk5MzEzM1A3VElRVlMwVlI0WSZlbmNyeXB0ZWRBZElkPUEwMDgzOTU5MUQzWVlZU1kwR0dSNyZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=	f	Unisex	Blue Light Blocking Glasses for Kids - Boys & Girls Unbreakable Frame (3-12 Years)	https://m.media-amazon.com/images/I/51fw9KAFGDL._AC_UL480_FMwebp_QL65_.jpg	accessory
175	14.950000	https://www.amazon.com/Kids-Blue-Light-Blocking-Glasses/dp/B07L8P9RYD/ref=sr_1_5?dchild=1&keywords=kids+glasses&qid=1606281644&sr=8-5	f	Unisex	Blue Light Glasses Kids Girls & Boys-Computer Gaming Eyeglasses - Anti Eyestrain	https://m.media-amazon.com/images/I/71iivpwty8L._AC_UL480_FMwebp_QL65_.jpg	accessory
176	42.900000	https://www.hottopic.com/product/hello-kitty-jujube-hk-kimono-brb-micro-backpack/14822402.html#q=sanrio&start=68&sz=60	f	Female	HELLO KITTY JUJUBE HK KIMONO BRB MICRO BACKPACK	https://hottopic.scene7.com/is/image/HotTopic/14822401_hi?$pdp_hero_zoom$	accessory
177	54.000000	https://trippnyc.com/product/tp4028-blupld/	t	Female	CLASP PLEATED SKIRT	https://trippnyc.com/wp-content/uploads/magictoolbox_cache/8c95d73fec130487c102a73bf1ab42ce/4/5/45309/1200x1200/3428890671/TP4028-BLUPLD_S.jpg	lowerSection
178	60.000000	https://www.dollskill.com/current-mood-vegan-leather-platform-mary-janes-black.html	t	Female	DAMNATION PLATFORM MARY JANES	https://media.dollskill.com/media/haIfhujKjtpJwnRDz45MEzEQsbIjuEaZ-34.jpg	footwear
179	60.000000	https://www.dollskill.com/sugar-thrillz-platform-heels-kitty-collar-black.html	t	Female	FELINE GOOD PLATFORM HEELS	https://media.dollskill.com/media/whjEmhCEftdEyAvlhUx2tDbnBMZwZK0u-34.jpg	footwear
180	39.000000	https://www.dollskill.com/lamoda-downtown-hiker-platform-boots.html	t	Female	DOWNTOWN HIKER PLATFORM BOOTS	https://media.dollskill.com/media/UJ7dMrDRrnUZmDZuoKrbydKSTeCI5KXj-34.jpg	footwear
181	29.000000	https://www.urbanoutfitters.com/shop/angel-tie-back-long-sleeve-tee?category=womens-tops&color=010&type=REGULAR&quantity=1	t	Female	Angel Tie-Back Long Sleeve Tee	https://s7d5.scene7.com/is/image/UrbanOutfitters/59913194_010_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=400	midSection
182	79.000000	https://www.urbanoutfitters.com/shop/uo-lennon-jacquard-cropped-sweater?category=womens-tops&color=015&type=REGULAR&quantity=1	t	Female	UO Lennon Jacquard Cropped Sweater	https://s7d5.scene7.com/is/image/UrbanOutfitters/59007849_015_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=400	midSection
183	30.900000	https://www.hottopic.com/product/misfits-fiend-skull-long-sleeve-t-shirt/14564574.html?cgid=guys-tops-long-sleeves#start=54	t	Male	MISFITS FIEND SKULL LONG-SLEEVE T-SHIRT	https://hottopic.scene7.com/is/image/HotTopic/14564574_hi?$pdp_hero_standard$	midSection
184	108.000000	https://trippnyc.com/product/is103ma-blkwht/	t	Male	SPLIT LEG BONDAGE PANT	https://trippnyc.com/wp-content/uploads/magictoolbox_cache/8c95d73fec130487c102a73bf1ab42ce/2/9/29605/thumb600x600/4232147842/IS103M-BLKWHT_F.jpg	lowerSection
185	30.900000	https://www.hottopic.com/product/good-boys-finish-last-long-sleeve-t-shirt-by-wizard-of-barge/14428633.html?cgid=guys-tops-long-sleeves#start=88&sz=60	t	Male	GOOD BOYS FINISH LAST LONG-SLEEVE T-SHIRT BY WIZARD OF BARGE	https://hottopic.scene7.com/is/image/HotTopic/14428633_hi?$pdp_hero_zoom$	midSection
186	24.490000	https://www2.hm.com/en_us/productpage.0806955002.html	t	Male	Faux Shearling Hoodie	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F41%2Fc3%2F41c3d85e0941a8854a2dcaddf5329bd08044a438.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_hoodiessweatshirts_hoodies%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]	midSection
187	129.000000	https://www2.hm.com/en_us/productpage.0908490001.html	t	Male	Faux Shearling-lined Jacket	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F16%2Fa7%2F16a70c8c95802160eb6ac582a10988f68f935c3a.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_jacketscoats_jackets%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/mobilemain]	midSection
188	14.990000	https://www2.hm.com/en_us/productpage.0685813041.html	t	Male	Relaxed Fit Sweatshirt	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F05%2Fb4%2F05b4425b04c6cd0a5308b202533444077cbfb0a3.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_hoodiessweatshirts_sweatshirts%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/mobilemain]	midSection
189	69.990000	https://www2.hm.com/en_us/productpage.0927657001.html	t	Male	Chunky Leather Sneakers	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fae%2Fee%2Faeeedc5294b8b47701feabf2df0abae9cc1ed9b9.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_shoes_sneakers%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]	footwear
190	198.000000	https://www.urbanoutfitters.com/shop/timberland-classic-work-boot?category=mens-clothing&color=016&type=REGULAR&quantity=1	t	Male	Timberland Classic Work Boot	https://s7d5.scene7.com/is/image/UrbanOutfitters/26847640_016_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=683	footwear
191	69.000000	https://www.urbanoutfitters.com/shop/dark-seas-signalman-thermal-long-sleeve-tee?category=mens-clothing&color=041&type=REGULAR&quantity=1	t	Male	Dark Seas Signalman Thermal Long Sleeve Tee	https://s7d5.scene7.com/is/image/UrbanOutfitters/58843228_041_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=683	midSection
192	34.000000	https://www.urbanoutfitters.com/shop/junk-food-bowie-tee?category=mens-clothing&color=001&type=REGULAR&quantity=1	t	Male	Junk Food Bowie Tee	https://s7d5.scene7.com/is/image/UrbanOutfitters/59680231_001_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=683	midSection
193	19.990000	https://www2.hm.com/en_us/productpage.0739239014.html	t	Male	Skinny Fit Suit Pants	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fd0%2F66%2Fd066fd202bed9dff5482b084a4bdc28580d233ec.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_trousers_trousers_skinny_all%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/mobilemain]	lowerSection
194	17.500000	https://www.pacsun.com/playboy/x-playboy-white-black-repeat-bunny-belt-0637600990005.html?dwvar_0637600990005_color=165&cgid=mens	t	Male	Playboy x Playboy White & Black Repeat Bunny Belt	https://www.pacsun.com/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dw7ecb4626/product_images/0637600990005NEW_00_165.jpg?sw=690&sh=1070&sm=fit	accessory
195	20.650000	https://www.pacsun.com/vans/checkerboard-world-long-sleeve-t-shirt-0103037910195.html?dwvar_0103037910195_color=010&cgid=mens-graphic-tees	t	Male	Vans Checkerboard World Long Sleeve T-Shirt	https://www.pacsun.com/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dwdd2b3fe1/product_images/0103037910195NEW_00_010.jpg?sw=690&sh=1070&sm=fit	midSection
196	9.970000	https://www.pacsun.com/pacsun/ashes-to-ashes-t-shirt-0120519270089.html?dwvar_0120519270089_color=010&cgid=mens-graphic-tees	t	Male	PacSun Ashes To Ashes T-Shirt	https://www.pacsun.com/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dwad92da2e/product_images/0120519270089NEW_00_010.jpg?sw=690&sh=1070&sm=fit	midSection
199	9.090000	https://www2.hm.com/en_us/productpage.0760876019.html	t	Unisex	Patterned Scarf	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F7e%2F7b%2F7e7bf46d537586e90f152a973605c7459325b042.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_accessories_scarves%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]	accessory
200	6.990000	https://www2.hm.com/en_us/productpage.0822495008.html	t	Unisex	Rib-knit Hat	https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F81%2Fe1%2F81e1f0e05a01c6480bd3a18d433208d8d60c1806.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_accessories_hatscaps_beanie%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]	headwear
201	60.000000	https://www.pacsun.com/vans/white-old-skool-shoes-0530037910212010.html?dwvar_0530037910212010_color=010&cgid=Unisex-all	t	Unisex	Vans White Old Skool Shoes	https://www.pacsun.com/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dw0df2e5b6/product_images/0530037910212U_01_010.jpg?sw=690&sh=1070&sm=fit	footwear
202	34.960000	https://www.pacsun.com/pacsun/cable-knit-crew-neck-sweater-0128508520027.html?dwvar_0128508520027_color=279&cgid=Unisex-all	t	Unisex	PacSun Cable Knit Crew Neck Sweater	https://www.pacsun.com/dw/image/v2/AAJE_PRD/on/demandware.static/-/Sites-pacsun_storefront_catalog/default/dwf031224c/product_images/0128508520027U_00_279.jpg?sw=690&sh=1070&sm=fit	midSection
203	6.930000	https://www.hottopic.com/product/edward-scissorhands-scissors-front-back-earrings/14047706.html#start=1	t	Unisex	EDWARD SCISSORHANDS SCISSORS FRONT/BACK EARRINGS	https://hottopic.scene7.com/is/image/HotTopic/14047705_hi?$pdp_hero_zoom$	accessory
204	7.630000	https://www.hottopic.com/product/skull-safety-pin-dice-chain-necklace-set/14248452.html?cgid=accessories-jewelry#start=4	t	Unisex	SKULL SAFETY PIN DICE CHAIN NECKLACE SET	https://hottopic.scene7.com/is/image/HotTopic/14248451_hi?$pdp_hero_zoom$	accessory
205	4.830000	https://www.hottopic.com/product/barbed-wire-chain-necklace/12413291.html	t	Unisex	BARBED WIRE CHAIN NECKLACE	https://hottopic.scene7.com/is/image/HotTopic/12413290_hi?$pdp_hero_zoom$	accessory
206	12.000000	https://www.urbanoutfitters.com/shop/dyed-face-mask?category=SEARCHRESULTS&color=040&searchparams=q%3Dface%2520mask&type=REGULAR&size=ONE%20SIZE&quantity=1	t	Unisex	Tie-Dye Face Mask	https://s7d5.scene7.com/is/image/UrbanOutfitters/57879959_040_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=683	accessory
207	13.000000	https://www.urbanoutfitters.com/shop/rilakkuma-reusable-face-mask?category=SEARCHRESULTS&color=020&searchparams=q%3Dface%2520mask&type=REGULAR&size=ONE%20SIZE&quantity=1	t	Unisex	Rilakkuma Reusable Face Mask	https://s7d5.scene7.com/is/image/UrbanOutfitters/59229518_020_b?$xlarge$=&fit=constrain&fmt=webp&qlt=80&wid=683	accessory
208	49.800000	https://en.mixxmix.com/product/hidelogo-patch-oversized-knit-sweater/55367/category/2839/display/1/	t	Unisex	Logo Patch Oversized Knit Sweater	https://akamai.poxo.com/mixxmix/en.mixxmix.com/web/product/big/20191129/c6fe4807c69fd4b0a013e20228ce8bce.gif	midSection
209	41.500000	https://en.mixxmix.com/product/seekstriped-turtleneck-knit-top/50938/category/2839/display/1/	t	Unisex	Striped Turtleneck Knit Top	https://akamai.poxo.com/mixxmix/en.mixxmix.com/web/product/big/201712/50938_shop1_410029.jpg	midSection
210	70.000000	https://en.mixxmix.com/product/heart-clubembroidered-logo-drawstring-hoodie/44422/category/2839/display/1/	t	Unisex	Embroidered Logo Drawstring Hoodie	https://akamai.poxo.com/mixxmix/en.mixxmix.com/web/product/big/201711/44422_shop1_659811.gif	midSection
\.


--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	Create schema	SQL	V1__Create_schema.sql	1487706174	rider	2020-12-01 18:15:43.795928	474	t
2	2	Populate schema	SQL	V2__Populate_schema.sql	1046569830	rider	2020-12-01 18:15:44.352332	216	t
\.


--
-- Data for Name: outfit; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.outfit (outfitid, headwear, lowersection, midsection, footwear, accessory) FROM stdin;
1	3	149	49	73	81
2	102	158	140	118	174
3	106	40	49	76	162
\.


--
-- Data for Name: savesclothing; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.savesclothing (cid, userid, createdat) FROM stdin;
15	4	2020-12-01 18:15:44.352332
15	5	2020-12-01 18:15:44.352332
15	6	2020-12-01 18:15:44.352332
15	7	2020-12-01 18:15:44.352332
57	4	2020-12-01 18:15:44.352332
57	5	2020-12-01 18:15:44.352332
63	4	2020-12-01 18:15:44.352332
57	6	2020-12-01 18:15:44.352332
15	3	2020-12-01 18:15:44.352332
21	10	2020-12-01 18:15:44.352332
21	11	2020-12-01 18:15:44.352332
35	5	2020-12-01 18:15:44.352332
99	6	2020-12-01 18:15:44.352332
69	6	2020-12-01 18:15:44.352332
63	6	2020-12-01 18:15:44.352332
4	6	2020-12-01 18:15:44.352332
97	6	2020-12-01 18:15:44.352332
97	14	2020-12-01 18:15:44.352332
97	7	2020-12-01 18:15:44.352332
93	8	2020-12-01 18:15:44.352332
93	6	2020-12-01 18:15:44.352332
93	1	2020-12-01 18:15:44.352332
97	11	2020-12-01 18:15:44.352332
\.


--
-- Data for Name: savesoutfit; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.savesoutfit (outfitid, userid, createdat) FROM stdin;
2	1	2020-12-01 18:15:44.352332
1	1	2020-12-01 18:15:44.352332
\.


--
-- Name: accounts_userid_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.accounts_userid_seq', 21, true);


--
-- Name: clothing_cid_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.clothing_cid_seq', 210, true);


--
-- Name: outfit_outfitid_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.outfit_outfitid_seq', 3, true);


--
-- Name: accounts accounts_email_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_email_key UNIQUE (email);


--
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (userid);


--
-- Name: accounts accounts_username_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_username_key UNIQUE (username);


--
-- Name: clothing clothing_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clothing
    ADD CONSTRAINT clothing_pkey PRIMARY KEY (cid);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: outfit outfit_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit
    ADD CONSTRAINT outfit_pkey PRIMARY KEY (outfitid);


--
-- Name: savesclothing savesclothing_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.savesclothing
    ADD CONSTRAINT savesclothing_pkey PRIMARY KEY (cid, userid);


--
-- Name: savesoutfit savesoutfit_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.savesoutfit
    ADD CONSTRAINT savesoutfit_pkey PRIMARY KEY (outfitid, userid);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: outfit outfit_accessory_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit
    ADD CONSTRAINT outfit_accessory_fkey FOREIGN KEY (accessory) REFERENCES public.clothing(cid) ON DELETE CASCADE;


--
-- Name: outfit outfit_footwear_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit
    ADD CONSTRAINT outfit_footwear_fkey FOREIGN KEY (footwear) REFERENCES public.clothing(cid) ON DELETE CASCADE;


--
-- Name: outfit outfit_headwear_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit
    ADD CONSTRAINT outfit_headwear_fkey FOREIGN KEY (headwear) REFERENCES public.clothing(cid) ON DELETE CASCADE;


--
-- Name: outfit outfit_lowersection_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit
    ADD CONSTRAINT outfit_lowersection_fkey FOREIGN KEY (lowersection) REFERENCES public.clothing(cid) ON DELETE CASCADE;


--
-- Name: outfit outfit_midsection_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.outfit
    ADD CONSTRAINT outfit_midsection_fkey FOREIGN KEY (midsection) REFERENCES public.clothing(cid) ON DELETE CASCADE;


--
-- Name: savesclothing savesclothing_cid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.savesclothing
    ADD CONSTRAINT savesclothing_cid_fkey FOREIGN KEY (cid) REFERENCES public.clothing(cid);


--
-- Name: savesclothing savesclothing_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.savesclothing
    ADD CONSTRAINT savesclothing_userid_fkey FOREIGN KEY (userid) REFERENCES public.accounts(userid);


--
-- Name: savesoutfit savesoutfit_outfitid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.savesoutfit
    ADD CONSTRAINT savesoutfit_outfitid_fkey FOREIGN KEY (outfitid) REFERENCES public.outfit(outfitid) ON DELETE CASCADE;


--
-- Name: savesoutfit savesoutfit_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.savesoutfit
    ADD CONSTRAINT savesoutfit_userid_fkey FOREIGN KEY (userid) REFERENCES public.accounts(userid);


--
-- PostgreSQL database dump complete
--

