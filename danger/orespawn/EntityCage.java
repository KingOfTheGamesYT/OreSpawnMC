/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.boss.EntityDragon;
/*      */ import net.minecraft.entity.boss.EntityDragonPart;
/*      */ import net.minecraft.entity.monster.EntitySkeleton;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.projectile.EntityThrowable;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EntityCage
/*      */   extends EntityThrowable
/*      */ {
/*   23 */   private float my_rotation = 0.0F;
/*   24 */   public int my_index = 160;
/*   25 */   private World throwerWorld = null;
/*   26 */   private EntityPlayer thrower = null;
/*      */ 
/*      */   
/*      */   public EntityCage(World par1World) {
/*   30 */     super(par1World);
/*   31 */     this.throwerWorld = par1World;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityCage(World par1World, int i) {
/*   36 */     super(par1World);
/*   37 */     this.throwerWorld = par1World;
/*   38 */     this.my_index = i;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityCage(World par1World, EntityPlayer par2EntityLiving, int i) {
/*   43 */     super(par1World, (EntityLivingBase)par2EntityLiving);
/*   44 */     this.throwerWorld = par1World;
/*   45 */     this.thrower = par2EntityLiving;
/*   46 */     this.my_index = i;
/*   47 */     if (this.thrower.worldObj != null) this.throwerWorld = this.thrower.worldObj;
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public int getCageIndex() {
/*   53 */     return this.my_index;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*   62 */     if (par1MovingObjectPosition.entityHit != null && this.rand.nextInt(10) >= 2) {
/*      */       
/*   64 */       if (this.throwerWorld != null) {
/*      */ 
/*      */ 
/*      */         
/*   68 */         for (int var3 = 0; var3 < 4; var3++) {
/*      */           
/*   70 */           this.throwerWorld.spawnParticle("smoke", par1MovingObjectPosition.entityHit.posX, par1MovingObjectPosition.entityHit.posY + 0.25D, par1MovingObjectPosition.entityHit.posZ, 0.0D, 0.0D, 0.0D);
/*   71 */           this.throwerWorld.spawnParticle("explode", par1MovingObjectPosition.entityHit.posX, par1MovingObjectPosition.entityHit.posY + 0.25D, par1MovingObjectPosition.entityHit.posZ, 0.0D, 0.0D, 0.0D);
/*   72 */           this.throwerWorld.spawnParticle("reddust", par1MovingObjectPosition.entityHit.posX, par1MovingObjectPosition.entityHit.posY + 0.25D, par1MovingObjectPosition.entityHit.posZ, 0.0D, 0.0D, 0.0D);
/*      */         } 
/*   74 */         if (this.thrower != null)
/*      */         {
/*   76 */           this.throwerWorld.playSoundAtEntity((Entity)this.thrower, "random.explode", 1.0F, 1.5F);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*   81 */       if (par1MovingObjectPosition.entityHit instanceof EntityPlayer) {
/*      */         
/*   83 */         if (!this.worldObj.isRemote) {
/*      */           
/*   85 */           dropItem(OreSpawnMain.CageEmpty, 1);
/*   86 */           setDead();
/*      */         } 
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */ 
/*      */       
/*   94 */       if (par1MovingObjectPosition.entityHit instanceof SpiderDriver) {
/*      */         
/*   96 */         par1MovingObjectPosition.entityHit.setDead();
/*   97 */         dropItem(OreSpawnMain.CagedSpiderDriver, 1);
/*      */       }
/*   99 */       else if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntitySpider) {
/*      */         
/*  101 */         if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityCaveSpider) {
/*      */           
/*  103 */           par1MovingObjectPosition.entityHit.setDead();
/*  104 */           dropItem(OreSpawnMain.CagedCaveSpider, 1);
/*      */         } else {
/*  106 */           par1MovingObjectPosition.entityHit.setDead();
/*  107 */           dropItem(OreSpawnMain.CagedSpider, 1);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  112 */       if (par1MovingObjectPosition.entityHit instanceof Crab) {
/*      */         
/*  114 */         par1MovingObjectPosition.entityHit.setDead();
/*  115 */         dropItem(OreSpawnMain.CagedCrab, 1);
/*      */       } 
/*      */       
/*  118 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityBat) {
/*      */         
/*  120 */         par1MovingObjectPosition.entityHit.setDead();
/*  121 */         dropItem(OreSpawnMain.CagedBat, 2);
/*      */       } 
/*      */       
/*  124 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityPig) {
/*      */         
/*  126 */         par1MovingObjectPosition.entityHit.setDead();
/*  127 */         dropItem(OreSpawnMain.CagedPig, 1);
/*      */       } 
/*      */       
/*  130 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntitySquid) {
/*      */         
/*  132 */         par1MovingObjectPosition.entityHit.setDead();
/*  133 */         dropItem(OreSpawnMain.CagedSquid, 1);
/*      */       } 
/*      */       
/*  136 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityChicken) {
/*      */         
/*  138 */         par1MovingObjectPosition.entityHit.setDead();
/*  139 */         dropItem(OreSpawnMain.CagedChicken, 1);
/*      */       } 
/*      */       
/*  142 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityCreeper) {
/*      */         
/*  144 */         par1MovingObjectPosition.entityHit.setDead();
/*  145 */         dropItem(OreSpawnMain.CagedCreeper, 1);
/*      */       } 
/*      */       
/*  148 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityHorse) {
/*      */         
/*  150 */         par1MovingObjectPosition.entityHit.setDead();
/*  151 */         dropItem(OreSpawnMain.CagedHorse, 1);
/*      */       } 
/*      */       
/*  154 */       if (par1MovingObjectPosition.entityHit instanceof EntitySkeleton) {
/*      */         
/*  156 */         EntitySkeleton sk = (EntitySkeleton)par1MovingObjectPosition.entityHit;
/*  157 */         if (sk.getSkeletonType() != 0) {
/*      */           
/*  159 */           dropItem(OreSpawnMain.CagedWitherSkeleton, 1);
/*      */         } else {
/*  161 */           dropItem(OreSpawnMain.CagedSkeleton, 1);
/*      */         } 
/*  163 */         par1MovingObjectPosition.entityHit.setDead();
/*      */       } 
/*      */       
/*  166 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityZombie)
/*      */       {
/*  168 */         if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityPigZombie) {
/*      */           
/*  170 */           par1MovingObjectPosition.entityHit.setDead();
/*  171 */           dropItem(OreSpawnMain.CagedZombiePigman, 1);
/*      */         } else {
/*  173 */           par1MovingObjectPosition.entityHit.setDead();
/*  174 */           dropItem(OreSpawnMain.CagedZombie, 1);
/*      */         } 
/*      */       }
/*      */       
/*  178 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntitySlime)
/*      */       {
/*      */         
/*  181 */         if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityMagmaCube) {
/*      */           
/*  183 */           par1MovingObjectPosition.entityHit.setDead();
/*  184 */           dropItem(OreSpawnMain.CagedMagmaCube, 1);
/*      */         } else {
/*  186 */           par1MovingObjectPosition.entityHit.setDead();
/*  187 */           dropItem(OreSpawnMain.CagedSlime, 1);
/*      */         } 
/*      */       }
/*      */       
/*  191 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityGhast) {
/*      */         
/*  193 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/*  195 */           if (!this.worldObj.isRemote) {
/*      */             
/*  197 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  198 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  202 */         par1MovingObjectPosition.entityHit.setDead();
/*  203 */         dropItem(OreSpawnMain.CagedGhast, 1);
/*      */       } 
/*      */       
/*  206 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityEnderman) {
/*      */         
/*  208 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/*  210 */           if (!this.worldObj.isRemote) {
/*      */             
/*  212 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  213 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  217 */         par1MovingObjectPosition.entityHit.setDead();
/*  218 */         dropItem(OreSpawnMain.CagedEnderman, 1);
/*      */       } 
/*      */       
/*  221 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntitySilverfish) {
/*      */         
/*  223 */         par1MovingObjectPosition.entityHit.setDead();
/*  224 */         dropItem(OreSpawnMain.CagedSilverfish, 2);
/*      */       } 
/*      */       
/*  227 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityWitch) {
/*      */         
/*  229 */         par1MovingObjectPosition.entityHit.setDead();
/*  230 */         dropItem(OreSpawnMain.CagedWitch, 1);
/*      */       } 
/*      */       
/*  233 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntitySheep) {
/*      */ 
/*      */         
/*  236 */         par1MovingObjectPosition.entityHit.setDead();
/*  237 */         dropItem(OreSpawnMain.CagedSheep, 1);
/*      */       } 
/*      */       
/*  240 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityWolf) {
/*      */         
/*  242 */         par1MovingObjectPosition.entityHit.setDead();
/*  243 */         dropItem(OreSpawnMain.CagedWolf, 1);
/*      */       } 
/*      */       
/*  246 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityOcelot) {
/*      */         
/*  248 */         par1MovingObjectPosition.entityHit.setDead();
/*  249 */         dropItem(OreSpawnMain.CagedOcelot, 1);
/*      */       } 
/*      */       
/*  252 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityBlaze) {
/*      */         
/*  254 */         par1MovingObjectPosition.entityHit.setDead();
/*  255 */         dropItem(OreSpawnMain.CagedBlaze, 1);
/*      */       } 
/*      */       
/*  258 */       if (par1MovingObjectPosition.entityHit instanceof Girlfriend) {
/*      */         
/*  260 */         Girlfriend gf = (Girlfriend)par1MovingObjectPosition.entityHit;
/*  261 */         if (!gf.isTamed()) {
/*  262 */           par1MovingObjectPosition.entityHit.setDead();
/*  263 */           dropItem(OreSpawnMain.CagedGirlfriend, 1);
/*      */         } 
/*      */       } 
/*  266 */       if (par1MovingObjectPosition.entityHit instanceof Boyfriend) {
/*      */         
/*  268 */         Boyfriend gf = (Boyfriend)par1MovingObjectPosition.entityHit;
/*  269 */         if (!gf.isTamed()) {
/*  270 */           par1MovingObjectPosition.entityHit.setDead();
/*  271 */           dropItem(OreSpawnMain.CagedBoyfriend, 1);
/*      */         } 
/*      */       } 
/*      */       
/*  275 */       if (par1MovingObjectPosition.entityHit instanceof EntityDragon) {
/*      */         
/*  277 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/*  279 */           if (!this.worldObj.isRemote) {
/*      */             
/*  281 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  282 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  286 */         EntityDragon dr = (EntityDragon)par1MovingObjectPosition.entityHit;
/*  287 */         dr.setDead();
/*  288 */         dropItem(OreSpawnMain.CagedEnderDragon, 1);
/*      */       } 
/*  290 */       if (par1MovingObjectPosition.entityHit instanceof EntityDragonPart) {
/*      */         
/*  292 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/*  294 */           if (!this.worldObj.isRemote) {
/*      */             
/*  296 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  297 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  301 */         EntityDragonPart dp = (EntityDragonPart)par1MovingObjectPosition.entityHit;
/*  302 */         EntityDragon dr = (EntityDragon)dp.entityDragonObj;
/*  303 */         dr.setDead();
/*  304 */         dropItem(OreSpawnMain.CagedEnderDragon, 1);
/*      */       } 
/*      */       
/*  307 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntitySnowman) {
/*      */         
/*  309 */         par1MovingObjectPosition.entityHit.setDead();
/*  310 */         dropItem(OreSpawnMain.CagedSnowGolem, 1);
/*      */       } 
/*      */       
/*  313 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityIronGolem) {
/*      */         
/*  315 */         par1MovingObjectPosition.entityHit.setDead();
/*  316 */         dropItem(OreSpawnMain.CagedIronGolem, 1);
/*      */       } 
/*      */       
/*  319 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.boss.EntityWither) {
/*      */         
/*  321 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/*  323 */           if (!this.worldObj.isRemote) {
/*      */             
/*  325 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  326 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  330 */         par1MovingObjectPosition.entityHit.setDead();
/*  331 */         dropItem(OreSpawnMain.CagedWitherBoss, 1);
/*      */       } 
/*  333 */       if (par1MovingObjectPosition.entityHit instanceof CrystalCow) {
/*      */         
/*  335 */         par1MovingObjectPosition.entityHit.setDead();
/*  336 */         dropItem(OreSpawnMain.CagedCrystalCow, 1);
/*  337 */         if (!this.worldObj.isRemote)
/*      */         {
/*      */           
/*  340 */           setDead();
/*      */         }
/*      */         return;
/*      */       } 
/*  344 */       if (par1MovingObjectPosition.entityHit instanceof EnchantedCow) {
/*      */         
/*  346 */         par1MovingObjectPosition.entityHit.setDead();
/*  347 */         dropItem(OreSpawnMain.CagedEnchantedCow, 1);
/*  348 */         if (!this.worldObj.isRemote)
/*      */         {
/*      */           
/*  351 */           setDead();
/*      */         }
/*      */         return;
/*      */       } 
/*  355 */       if (par1MovingObjectPosition.entityHit instanceof GoldCow) {
/*      */         
/*  357 */         par1MovingObjectPosition.entityHit.setDead();
/*  358 */         dropItem(OreSpawnMain.CagedGoldCow, 1);
/*  359 */         if (!this.worldObj.isRemote)
/*      */         {
/*      */           
/*  362 */           setDead();
/*      */         }
/*      */         return;
/*      */       } 
/*  366 */       if (par1MovingObjectPosition.entityHit instanceof RedCow) {
/*      */         
/*  368 */         par1MovingObjectPosition.entityHit.setDead();
/*  369 */         dropItem(OreSpawnMain.CagedRedCow, 1);
/*  370 */         if (!this.worldObj.isRemote)
/*      */         {
/*      */           
/*  373 */           setDead();
/*      */         }
/*      */         return;
/*      */       } 
/*  377 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityCow) {
/*      */         
/*  379 */         if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityMooshroom) {
/*      */           
/*  381 */           par1MovingObjectPosition.entityHit.setDead();
/*  382 */           dropItem(OreSpawnMain.CagedMooshroom, 1);
/*      */         } else {
/*  384 */           par1MovingObjectPosition.entityHit.setDead();
/*  385 */           dropItem(OreSpawnMain.CagedCow, 1);
/*      */         } 
/*  387 */         if (!this.worldObj.isRemote)
/*      */         {
/*      */           
/*  390 */           setDead();
/*      */         }
/*      */         return;
/*      */       } 
/*  394 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.passive.EntityVillager) {
/*      */         
/*  396 */         par1MovingObjectPosition.entityHit.setDead();
/*  397 */         dropItem(OreSpawnMain.CagedVillager, 1);
/*  398 */         if (!this.worldObj.isRemote)
/*      */         {
/*      */           
/*  401 */           setDead();
/*      */         }
/*      */         return;
/*      */       } 
/*  405 */       if (par1MovingObjectPosition.entityHit instanceof Mothra) {
/*      */         
/*  407 */         if (this.rand.nextInt(10) < 4) {
/*      */           
/*  409 */           if (!this.worldObj.isRemote) {
/*      */             
/*  411 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  412 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  416 */         par1MovingObjectPosition.entityHit.setDead();
/*  417 */         dropItem(OreSpawnMain.CagedMOTHRA, 1);
/*      */       } 
/*  419 */       if (par1MovingObjectPosition.entityHit instanceof Alosaurus) {
/*      */         
/*  421 */         if (this.rand.nextInt(10) < 4) {
/*      */           
/*  423 */           if (!this.worldObj.isRemote) {
/*      */             
/*  425 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  426 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  430 */         par1MovingObjectPosition.entityHit.setDead();
/*  431 */         dropItem(OreSpawnMain.CagedAlo, 1);
/*      */       } 
/*  433 */       if (par1MovingObjectPosition.entityHit instanceof Cryolophosaurus) {
/*      */         
/*  435 */         par1MovingObjectPosition.entityHit.setDead();
/*  436 */         dropItem(OreSpawnMain.CagedCryo, 1);
/*      */       } 
/*  438 */       if (par1MovingObjectPosition.entityHit instanceof Camarasaurus) {
/*      */         
/*  440 */         par1MovingObjectPosition.entityHit.setDead();
/*  441 */         dropItem(OreSpawnMain.CagedCama, 1);
/*      */       } 
/*  443 */       if (par1MovingObjectPosition.entityHit instanceof VelocityRaptor) {
/*      */         
/*  445 */         par1MovingObjectPosition.entityHit.setDead();
/*  446 */         dropItem(OreSpawnMain.CagedVelo, 1);
/*      */       } 
/*  448 */       if (par1MovingObjectPosition.entityHit instanceof Hydrolisc) {
/*      */         
/*  450 */         par1MovingObjectPosition.entityHit.setDead();
/*  451 */         dropItem(OreSpawnMain.CagedHydro, 1);
/*      */       } 
/*  453 */       if (par1MovingObjectPosition.entityHit instanceof Basilisk) {
/*      */         
/*  455 */         if (this.rand.nextInt(10) < 6) {
/*      */           
/*  457 */           if (!this.worldObj.isRemote) {
/*      */             
/*  459 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  460 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  464 */         par1MovingObjectPosition.entityHit.setDead();
/*  465 */         dropItem(OreSpawnMain.CagedBasil, 1);
/*      */       } 
/*  467 */       if (par1MovingObjectPosition.entityHit instanceof Dragonfly) {
/*      */         
/*  469 */         par1MovingObjectPosition.entityHit.setDead();
/*  470 */         dropItem(OreSpawnMain.CagedDragonfly, 2);
/*      */       } 
/*  472 */       if (par1MovingObjectPosition.entityHit instanceof EmperorScorpion) {
/*      */         
/*  474 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/*  476 */           if (!this.worldObj.isRemote) {
/*      */             
/*  478 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  479 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  483 */         par1MovingObjectPosition.entityHit.setDead();
/*  484 */         dropItem(OreSpawnMain.CagedEmperorScorpion, 1);
/*      */       } 
/*  486 */       if (par1MovingObjectPosition.entityHit instanceof Cephadrome) {
/*      */         
/*  488 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/*  490 */           if (!this.worldObj.isRemote) {
/*      */             
/*  492 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  493 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  497 */         par1MovingObjectPosition.entityHit.setDead();
/*  498 */         dropItem(OreSpawnMain.CagedCephadrome, 1);
/*      */       } 
/*  500 */       if (par1MovingObjectPosition.entityHit instanceof Dragon) {
/*      */         
/*  502 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/*  504 */           if (!this.worldObj.isRemote) {
/*      */             
/*  506 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  507 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  511 */         par1MovingObjectPosition.entityHit.setDead();
/*  512 */         dropItem(OreSpawnMain.CagedDragon, 1);
/*      */       } 
/*  514 */       if (par1MovingObjectPosition.entityHit instanceof Scorpion) {
/*      */         
/*  516 */         par1MovingObjectPosition.entityHit.setDead();
/*  517 */         dropItem(OreSpawnMain.CagedScorpion, 1);
/*      */       } 
/*  519 */       if (par1MovingObjectPosition.entityHit instanceof CaveFisher) {
/*      */         
/*  521 */         par1MovingObjectPosition.entityHit.setDead();
/*  522 */         dropItem(OreSpawnMain.CagedCaveFisher, 1);
/*      */       } 
/*  524 */       if (par1MovingObjectPosition.entityHit instanceof Spyro) {
/*      */         
/*  526 */         par1MovingObjectPosition.entityHit.setDead();
/*  527 */         dropItem(OreSpawnMain.CagedSpyro, 1);
/*      */       } 
/*  529 */       if (par1MovingObjectPosition.entityHit instanceof Baryonyx) {
/*      */         
/*  531 */         par1MovingObjectPosition.entityHit.setDead();
/*  532 */         dropItem(OreSpawnMain.CagedBaryonyx, 1);
/*      */       } 
/*  534 */       if (par1MovingObjectPosition.entityHit instanceof GammaMetroid) {
/*      */         
/*  536 */         par1MovingObjectPosition.entityHit.setDead();
/*  537 */         dropItem(OreSpawnMain.CagedGammaMetroid, 1);
/*      */       } 
/*  539 */       if (par1MovingObjectPosition.entityHit instanceof Cockateil) {
/*      */         
/*  541 */         par1MovingObjectPosition.entityHit.setDead();
/*  542 */         dropItem(OreSpawnMain.CagedCockateil, 4);
/*      */       } 
/*  544 */       if (par1MovingObjectPosition.entityHit instanceof AttackSquid) {
/*      */         
/*  546 */         par1MovingObjectPosition.entityHit.setDead();
/*  547 */         dropItem(OreSpawnMain.CagedAttackSquid, 6);
/*      */       } 
/*  549 */       if (par1MovingObjectPosition.entityHit instanceof Kyuubi) {
/*      */         
/*  551 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  553 */           if (!this.worldObj.isRemote) {
/*      */             
/*  555 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  556 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  560 */         par1MovingObjectPosition.entityHit.setDead();
/*  561 */         dropItem(OreSpawnMain.CagedKyuubi, 1);
/*      */       } 
/*  563 */       if (par1MovingObjectPosition.entityHit instanceof WaterDragon) {
/*      */         
/*  565 */         if (this.rand.nextInt(10) < 6) {
/*      */           
/*  567 */           if (!this.worldObj.isRemote) {
/*      */             
/*  569 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  570 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  574 */         par1MovingObjectPosition.entityHit.setDead();
/*  575 */         dropItem(OreSpawnMain.CagedWaterDragon, 1);
/*      */       } 
/*  577 */       if (par1MovingObjectPosition.entityHit instanceof Kraken) {
/*      */         
/*  579 */         if (this.rand.nextInt(100) < 95) {
/*      */           
/*  581 */           if (!this.worldObj.isRemote) {
/*      */             
/*  583 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  584 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  588 */         par1MovingObjectPosition.entityHit.setDead();
/*  589 */         dropItem(OreSpawnMain.CagedKraken, 1);
/*      */       } 
/*  591 */       if (par1MovingObjectPosition.entityHit instanceof Lizard) {
/*      */         
/*  593 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/*  595 */           if (!this.worldObj.isRemote) {
/*      */             
/*  597 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  598 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  602 */         par1MovingObjectPosition.entityHit.setDead();
/*  603 */         dropItem(OreSpawnMain.CagedLizard, 1);
/*      */       } 
/*  605 */       if (par1MovingObjectPosition.entityHit instanceof Alien) {
/*      */         
/*  607 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/*  609 */           if (!this.worldObj.isRemote) {
/*      */             
/*  611 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  612 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  616 */         par1MovingObjectPosition.entityHit.setDead();
/*  617 */         dropItem(OreSpawnMain.CagedAlien, 1);
/*      */       } 
/*  619 */       if (par1MovingObjectPosition.entityHit instanceof Bee) {
/*      */         
/*  621 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  623 */           if (!this.worldObj.isRemote) {
/*      */             
/*  625 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  626 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  630 */         par1MovingObjectPosition.entityHit.setDead();
/*  631 */         dropItem(OreSpawnMain.CagedBee, 1);
/*      */       } 
/*  633 */       if (par1MovingObjectPosition.entityHit instanceof Firefly) {
/*      */         
/*  635 */         par1MovingObjectPosition.entityHit.setDead();
/*  636 */         dropItem(OreSpawnMain.CagedFirefly, 1);
/*      */       } 
/*  638 */       if (par1MovingObjectPosition.entityHit instanceof Chipmunk) {
/*      */         
/*  640 */         par1MovingObjectPosition.entityHit.setDead();
/*  641 */         dropItem(OreSpawnMain.CagedChipmunk, 1);
/*      */       } 
/*  643 */       if (par1MovingObjectPosition.entityHit instanceof Gazelle) {
/*      */         
/*  645 */         par1MovingObjectPosition.entityHit.setDead();
/*  646 */         dropItem(OreSpawnMain.CagedGazelle, 1);
/*      */       } 
/*  648 */       if (par1MovingObjectPosition.entityHit instanceof Ostrich) {
/*      */         
/*  650 */         par1MovingObjectPosition.entityHit.setDead();
/*  651 */         dropItem(OreSpawnMain.CagedOstrich, 1);
/*      */       } 
/*  653 */       if (par1MovingObjectPosition.entityHit instanceof TrooperBug) {
/*      */         
/*  655 */         if (this.rand.nextInt(10) < 6) {
/*      */           
/*  657 */           if (!this.worldObj.isRemote) {
/*      */             
/*  659 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  660 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  664 */         par1MovingObjectPosition.entityHit.setDead();
/*  665 */         dropItem(OreSpawnMain.CagedTrooper, 1);
/*      */       } 
/*  667 */       if (par1MovingObjectPosition.entityHit instanceof SpitBug) {
/*      */         
/*  669 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  671 */           if (!this.worldObj.isRemote) {
/*      */             
/*  673 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  674 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  678 */         par1MovingObjectPosition.entityHit.setDead();
/*  679 */         dropItem(OreSpawnMain.CagedSpit, 1);
/*      */       } 
/*  681 */       if (par1MovingObjectPosition.entityHit instanceof StinkBug) {
/*      */         
/*  683 */         par1MovingObjectPosition.entityHit.setDead();
/*  684 */         dropItem(OreSpawnMain.CagedStink, 1);
/*      */       } 
/*  686 */       if (par1MovingObjectPosition.entityHit instanceof CreepingHorror) {
/*      */         
/*  688 */         par1MovingObjectPosition.entityHit.setDead();
/*  689 */         dropItem(OreSpawnMain.CagedCreepingHorror, 1);
/*      */       } 
/*  691 */       if (par1MovingObjectPosition.entityHit instanceof TerribleTerror) {
/*      */         
/*  693 */         par1MovingObjectPosition.entityHit.setDead();
/*  694 */         dropItem(OreSpawnMain.CagedTerribleTerror, 1);
/*      */       } 
/*  696 */       if (par1MovingObjectPosition.entityHit instanceof CliffRacer) {
/*      */         
/*  698 */         par1MovingObjectPosition.entityHit.setDead();
/*  699 */         dropItem(OreSpawnMain.CagedCliffRacer, 1);
/*      */       } 
/*  701 */       if (par1MovingObjectPosition.entityHit instanceof Triffid) {
/*      */         
/*  703 */         if (this.rand.nextInt(10) < 6) {
/*      */           
/*  705 */           if (!this.worldObj.isRemote) {
/*      */             
/*  707 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  708 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  712 */         par1MovingObjectPosition.entityHit.setDead();
/*  713 */         dropItem(OreSpawnMain.CagedTriffid, 1);
/*      */       } 
/*  715 */       if (par1MovingObjectPosition.entityHit instanceof PitchBlack) {
/*      */         
/*  717 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/*  719 */           if (!this.worldObj.isRemote) {
/*      */             
/*  721 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  722 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  726 */         par1MovingObjectPosition.entityHit.setDead();
/*  727 */         dropItem(OreSpawnMain.CagedPitchBlack, 1);
/*      */       } 
/*  729 */       if (par1MovingObjectPosition.entityHit instanceof LurkingTerror) {
/*      */         
/*  731 */         par1MovingObjectPosition.entityHit.setDead();
/*  732 */         dropItem(OreSpawnMain.CagedLurkingTerror, 1);
/*      */       } 
/*  734 */       if (par1MovingObjectPosition.entityHit instanceof WormSmall) {
/*      */         
/*  736 */         par1MovingObjectPosition.entityHit.setDead();
/*  737 */         dropItem(OreSpawnMain.CagedSmallWorm, 1);
/*      */       } 
/*  739 */       if (par1MovingObjectPosition.entityHit instanceof WormMedium) {
/*      */         
/*  741 */         par1MovingObjectPosition.entityHit.setDead();
/*  742 */         dropItem(OreSpawnMain.CagedMediumWorm, 1);
/*      */       } 
/*  744 */       if (par1MovingObjectPosition.entityHit instanceof Cassowary) {
/*      */         
/*  746 */         par1MovingObjectPosition.entityHit.setDead();
/*  747 */         dropItem(OreSpawnMain.CagedCassowary, 1);
/*      */       } 
/*  749 */       if (par1MovingObjectPosition.entityHit instanceof CloudShark) {
/*      */         
/*  751 */         par1MovingObjectPosition.entityHit.setDead();
/*  752 */         dropItem(OreSpawnMain.CagedCloudShark, 1);
/*      */       } 
/*  754 */       if (par1MovingObjectPosition.entityHit instanceof GoldFish) {
/*      */         
/*  756 */         par1MovingObjectPosition.entityHit.setDead();
/*  757 */         dropItem(OreSpawnMain.CagedGoldFish, 1);
/*      */       } 
/*  759 */       if (par1MovingObjectPosition.entityHit instanceof LeafMonster) {
/*      */         
/*  761 */         par1MovingObjectPosition.entityHit.setDead();
/*  762 */         dropItem(OreSpawnMain.CagedLeafMonster, 1);
/*      */       } 
/*  764 */       if (par1MovingObjectPosition.entityHit instanceof WormLarge) {
/*      */         
/*  766 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/*  768 */           if (!this.worldObj.isRemote) {
/*      */             
/*  770 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  771 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  775 */         par1MovingObjectPosition.entityHit.setDead();
/*  776 */         dropItem(OreSpawnMain.CagedLargeWorm, 1);
/*      */       } 
/*  778 */       if (par1MovingObjectPosition.entityHit instanceof EnderKnight) {
/*      */         
/*  780 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  782 */           if (!this.worldObj.isRemote) {
/*      */             
/*  784 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  785 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  789 */         par1MovingObjectPosition.entityHit.setDead();
/*  790 */         dropItem(OreSpawnMain.CagedEnderKnight, 1);
/*      */       } 
/*  792 */       if (par1MovingObjectPosition.entityHit instanceof EnderReaper) {
/*      */         
/*  794 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/*  796 */           if (!this.worldObj.isRemote) {
/*      */             
/*  798 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  799 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  803 */         par1MovingObjectPosition.entityHit.setDead();
/*  804 */         dropItem(OreSpawnMain.CagedEnderReaper, 1);
/*      */       } 
/*  806 */       if (par1MovingObjectPosition.entityHit instanceof Beaver) {
/*      */         
/*  808 */         par1MovingObjectPosition.entityHit.setDead();
/*  809 */         dropItem(OreSpawnMain.CagedBeaver, 1);
/*      */       } 
/*  811 */       if (par1MovingObjectPosition.entityHit instanceof Urchin) {
/*      */         
/*  813 */         par1MovingObjectPosition.entityHit.setDead();
/*  814 */         dropItem(OreSpawnMain.CagedUrchin, 1);
/*      */       } 
/*  816 */       if (par1MovingObjectPosition.entityHit instanceof Flounder) {
/*      */         
/*  818 */         par1MovingObjectPosition.entityHit.setDead();
/*  819 */         dropItem(OreSpawnMain.CagedFlounder, 1);
/*      */       } 
/*  821 */       if (par1MovingObjectPosition.entityHit instanceof Skate) {
/*      */         
/*  823 */         par1MovingObjectPosition.entityHit.setDead();
/*  824 */         dropItem(OreSpawnMain.CagedSkate, 1);
/*      */       } 
/*  826 */       if (par1MovingObjectPosition.entityHit instanceof Rotator) {
/*      */         
/*  828 */         par1MovingObjectPosition.entityHit.setDead();
/*  829 */         dropItem(OreSpawnMain.CagedRotator, 1);
/*      */       } 
/*  831 */       if (par1MovingObjectPosition.entityHit instanceof Peacock) {
/*      */         
/*  833 */         par1MovingObjectPosition.entityHit.setDead();
/*  834 */         dropItem(OreSpawnMain.CagedPeacock, 1);
/*      */       } 
/*  836 */       if (par1MovingObjectPosition.entityHit instanceof Fairy) {
/*      */         
/*  838 */         par1MovingObjectPosition.entityHit.setDead();
/*  839 */         dropItem(OreSpawnMain.CagedFairy, 1);
/*      */       } 
/*  841 */       if (par1MovingObjectPosition.entityHit instanceof DungeonBeast) {
/*      */         
/*  843 */         par1MovingObjectPosition.entityHit.setDead();
/*  844 */         dropItem(OreSpawnMain.CagedDungeonBeast, 1);
/*      */       } 
/*  846 */       if (par1MovingObjectPosition.entityHit instanceof Vortex) {
/*      */         
/*  848 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  850 */           if (!this.worldObj.isRemote) {
/*      */             
/*  852 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  853 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  857 */         par1MovingObjectPosition.entityHit.setDead();
/*  858 */         dropItem(OreSpawnMain.CagedVortex, 1);
/*      */       } 
/*  860 */       if (par1MovingObjectPosition.entityHit instanceof Rat) {
/*      */         
/*  862 */         par1MovingObjectPosition.entityHit.setDead();
/*  863 */         dropItem(OreSpawnMain.CagedRat, 1);
/*      */       } 
/*  865 */       if (par1MovingObjectPosition.entityHit instanceof Whale) {
/*      */         
/*  867 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/*  869 */           if (!this.worldObj.isRemote) {
/*      */             
/*  871 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  872 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  876 */         par1MovingObjectPosition.entityHit.setDead();
/*  877 */         dropItem(OreSpawnMain.CagedWhale, 1);
/*      */       } 
/*  879 */       if (par1MovingObjectPosition.entityHit instanceof Irukandji) {
/*      */         
/*  881 */         par1MovingObjectPosition.entityHit.setDead();
/*  882 */         dropItem(OreSpawnMain.CagedIrukandji, 1);
/*      */       } 
/*  884 */       if (par1MovingObjectPosition.entityHit instanceof Stinky) {
/*      */         
/*  886 */         par1MovingObjectPosition.entityHit.setDead();
/*  887 */         dropItem(OreSpawnMain.CagedStinky, 1);
/*      */       } 
/*  889 */       if (par1MovingObjectPosition.entityHit instanceof Mantis) {
/*      */         
/*  891 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  893 */           if (!this.worldObj.isRemote) {
/*      */             
/*  895 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  896 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  900 */         par1MovingObjectPosition.entityHit.setDead();
/*  901 */         dropItem(OreSpawnMain.CagedMantis, 1);
/*      */       } 
/*  903 */       if (par1MovingObjectPosition.entityHit instanceof TRex) {
/*      */         
/*  905 */         if (this.rand.nextInt(10) < 4) {
/*      */           
/*  907 */           if (!this.worldObj.isRemote) {
/*      */             
/*  909 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  910 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  914 */         par1MovingObjectPosition.entityHit.setDead();
/*  915 */         dropItem(OreSpawnMain.CagedTRex, 1);
/*      */       } 
/*  917 */       if (par1MovingObjectPosition.entityHit instanceof HerculesBeetle) {
/*      */         
/*  919 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/*  921 */           if (!this.worldObj.isRemote) {
/*      */             
/*  923 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  924 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  928 */         par1MovingObjectPosition.entityHit.setDead();
/*  929 */         dropItem(OreSpawnMain.CagedHercules, 1);
/*      */       } 
/*  931 */       if (par1MovingObjectPosition.entityHit instanceof EasterBunny) {
/*      */         
/*  933 */         par1MovingObjectPosition.entityHit.setDead();
/*  934 */         dropItem(OreSpawnMain.CagedEasterBunny, 1);
/*      */       } 
/*  936 */       if (par1MovingObjectPosition.entityHit instanceof CaterKiller) {
/*      */         
/*  938 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/*  940 */           if (!this.worldObj.isRemote) {
/*      */             
/*  942 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  943 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  947 */         par1MovingObjectPosition.entityHit.setDead();
/*  948 */         dropItem(OreSpawnMain.CagedCaterKiller, 1);
/*      */       } 
/*  950 */       if (par1MovingObjectPosition.entityHit instanceof Molenoid) {
/*      */         
/*  952 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/*  954 */           if (!this.worldObj.isRemote) {
/*      */             
/*  956 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  957 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  961 */         par1MovingObjectPosition.entityHit.setDead();
/*  962 */         dropItem(OreSpawnMain.CagedMolenoid, 1);
/*      */       } 
/*  964 */       if (par1MovingObjectPosition.entityHit instanceof SeaMonster) {
/*      */         
/*  966 */         if (this.rand.nextInt(10) < 3) {
/*      */           
/*  968 */           if (!this.worldObj.isRemote) {
/*      */             
/*  970 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  971 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  975 */         par1MovingObjectPosition.entityHit.setDead();
/*  976 */         dropItem(OreSpawnMain.CagedSeaMonster, 1);
/*      */       } 
/*  978 */       if (par1MovingObjectPosition.entityHit instanceof SeaViper) {
/*      */         
/*  980 */         if (this.rand.nextInt(10) < 4) {
/*      */           
/*  982 */           if (!this.worldObj.isRemote) {
/*      */             
/*  984 */             dropItem(OreSpawnMain.CageEmpty, 1);
/*  985 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/*  989 */         par1MovingObjectPosition.entityHit.setDead();
/*  990 */         dropItem(OreSpawnMain.CagedSeaViper, 1);
/*      */       } 
/*  992 */       if (par1MovingObjectPosition.entityHit instanceof RubberDucky) {
/*      */         
/*  994 */         par1MovingObjectPosition.entityHit.setDead();
/*  995 */         dropItem(OreSpawnMain.CagedRubberDucky, 1);
/*      */       } 
/*  997 */       if (par1MovingObjectPosition.entityHit instanceof Leon) {
/*      */         
/*  999 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/* 1001 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1003 */             dropItem(OreSpawnMain.CageEmpty, 1);
/* 1004 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/* 1008 */         par1MovingObjectPosition.entityHit.setDead();
/* 1009 */         dropItem(OreSpawnMain.CagedLeon, 1);
/*      */       } 
/* 1011 */       if (par1MovingObjectPosition.entityHit instanceof Hammerhead) {
/*      */         
/* 1013 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/* 1015 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1017 */             dropItem(OreSpawnMain.CageEmpty, 1);
/* 1018 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/* 1022 */         par1MovingObjectPosition.entityHit.setDead();
/* 1023 */         dropItem(OreSpawnMain.CagedHammerhead, 1);
/*      */       } 
/* 1025 */       if (par1MovingObjectPosition.entityHit instanceof BandP) {
/*      */         
/* 1027 */         par1MovingObjectPosition.entityHit.setDead();
/* 1028 */         dropItem(OreSpawnMain.CagedCriminal, 1);
/*      */       } 
/* 1030 */       if (par1MovingObjectPosition.entityHit instanceof Cricket) {
/*      */         
/* 1032 */         par1MovingObjectPosition.entityHit.setDead();
/* 1033 */         dropItem(OreSpawnMain.CagedCricket, 1);
/*      */       } 
/* 1035 */       if (par1MovingObjectPosition.entityHit instanceof Frog) {
/*      */         
/* 1037 */         par1MovingObjectPosition.entityHit.setDead();
/* 1038 */         dropItem(OreSpawnMain.CagedFrog, 1);
/*      */       } 
/* 1040 */       if (par1MovingObjectPosition.entityHit instanceof Brutalfly) {
/*      */         
/* 1042 */         if (this.rand.nextInt(10) < 5) {
/*      */           
/* 1044 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1046 */             dropItem(OreSpawnMain.CageEmpty, 1);
/* 1047 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/* 1051 */         par1MovingObjectPosition.entityHit.setDead();
/* 1052 */         dropItem(OreSpawnMain.CagedBrutalfly, 1);
/*      */       } 
/* 1054 */       if (par1MovingObjectPosition.entityHit instanceof Nastysaurus) {
/*      */         
/* 1056 */         if (this.rand.nextInt(10) < 7) {
/*      */           
/* 1058 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1060 */             dropItem(OreSpawnMain.CageEmpty, 1);
/* 1061 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/* 1065 */         par1MovingObjectPosition.entityHit.setDead();
/* 1066 */         dropItem(OreSpawnMain.CagedNastysaurus, 1);
/*      */       } 
/* 1068 */       if (par1MovingObjectPosition.entityHit instanceof Pointysaurus)
/*      */       {
/* 1070 */         if (this.rand.nextInt(10) < 2) {
/*      */           
/* 1072 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1074 */             dropItem(OreSpawnMain.CageEmpty, 1);
/* 1075 */             setDead();
/*      */           } 
/*      */           return;
/*      */         } 
/* 1079 */         par1MovingObjectPosition.entityHit.setDead();
/* 1080 */         dropItem(OreSpawnMain.CagedPointysaurus, 1);
/*      */       }
/*      */     
/*      */     }
/* 1084 */     else if (!this.worldObj.isRemote) {
/*      */ 
/*      */       
/* 1087 */       dropItem(OreSpawnMain.CageEmpty, 1);
/*      */     } 
/*      */ 
/*      */     
/* 1091 */     if (!this.worldObj.isRemote)
/*      */     {
/*      */       
/* 1094 */       setDead();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/* 1111 */     super.onUpdate();
/*      */ 
/*      */     
/* 1114 */     this.my_rotation += 20.0F;
/*      */     
/* 1116 */     while (this.my_rotation > 360.0F) {
/* 1117 */       this.my_rotation -= 360.0F;
/*      */     }
/*      */ 
/*      */     
/* 1121 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */