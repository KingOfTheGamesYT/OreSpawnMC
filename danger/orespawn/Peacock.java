/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Peacock
/*     */   extends EntityAnimal
/*     */ {
/*  51 */   private float moveSpeed = 0.38F;
/*  52 */   int my_blink = 0;
/*  53 */   int blinkcount = 0;
/*  54 */   int blinker = 0;
/*  55 */   private GenericTargetSorter TargetSorter = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public Peacock(World par1World) {
/*  60 */     super(par1World);
/*     */     
/*  62 */     setSize(0.65F, 1.2F);
/*  63 */     this.fireResistance = 100;
/*  64 */     this.experienceValue = 8;
/*  65 */     this.my_blink = 20 + this.rand.nextInt(50);
/*  66 */     this.blinkcount = 0;
/*  67 */     this.blinker = 0;
/*  68 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  69 */     getNavigator().setAvoidsWater(true);
/*  70 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  71 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  72 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D));
/*  73 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 12.0F, 1.2000000476837158D, 1.600000023841858D));
/*  74 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  75 */     this.tasks.addTask(5, new MyEntityAIWander((EntityCreature)this, 1.0F));
/*  76 */     this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  77 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, Termite.class, 6, true));
/*     */   
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  82 */     super.applyEntityAttributes();
/*  83 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  84 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  85 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  86 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  91 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBlink() {
/*  96 */     return this.blinker;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 103 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 104 */     super.onUpdate();
/* 105 */     this.blinkcount++;
/* 106 */     if (this.blinkcount > this.my_blink) {
/* 107 */       this.blinkcount = 0;
/*     */       
/* 109 */       if (this.blinker > 0) {
/* 110 */         this.blinker = 0;
/* 111 */         this.my_blink = 50 + this.worldObj.rand.nextInt(300);
/*     */       } else {
/* 113 */         this.blinker = 1;
/* 114 */         this.my_blink = 25 + this.worldObj.rand.nextInt(100);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 126 */     for (int k = -1; k < 1; k++) {
/*     */       
/* 128 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 130 */         for (int i = 1; i < 3; i++) {
/*     */           
/* 132 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 133 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 137 */     long t = this.worldObj.getWorldTime();
/* 138 */     t %= 24000L;
/* 139 */     if (t > 12000L) return false; 
/* 140 */     if (this.posY < 50.0D || this.posY > 100.0D) return false; 
/* 141 */     if (findBuddies() > 2) return false; 
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 161 */     return 15;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 169 */     if (this.worldObj.rand.nextInt(8) != 1) return null; 
/* 170 */     return "orespawn:peacocklive";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 178 */     return "orespawn:peacockhit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 186 */     return "orespawn:peacockdead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 194 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 202 */     return OreSpawnMain.MyRawPeacock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 211 */     dropItem(OreSpawnMain.MyRawPeacock, 1);
/* 212 */     if (this.worldObj.rand.nextInt(3) == 1) {
/* 213 */       dropItem(OreSpawnMain.MyRawPeacock, 1);
/*     */     }
/* 215 */     if (this.worldObj.rand.nextInt(2) == 1) {
/* 216 */       dropItem(OreSpawnMain.MyPeacockFeather, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 225 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 6.0F);
/* 226 */     return var4;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack LayAnEgg(Item index, int par1) {
/* 231 */     EntityItem var3 = null;
/* 232 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 234 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 236 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 237 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 245 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 246 */     super.updateAITasks();
/*     */     
/* 248 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
/*     */       return; 
/* 250 */     if (this.worldObj.rand.nextInt(10) == 1) {
/*     */       
/* 252 */       EntityLivingBase e = findSomethingToAttack();
/* 253 */       if (e != null) {
/* 254 */         if (getDistanceSqToEntity((Entity)e) < 4.0D) {
/* 255 */           attackEntityAsMob((Entity)e);
/*     */         } else {
/* 257 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       }
/*     */     } 
/* 261 */     if (this.worldObj.rand.nextInt(5000) == 1) LayAnEgg(OreSpawnMain.PeacockEgg, 1 + this.worldObj.rand.nextInt(3));
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 269 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 271 */     if (par1EntityLiving == null)
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     if (par1EntityLiving == this)
/*     */     {
/* 277 */       return false;
/*     */     }
/* 279 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 282 */       return false;
/*     */     }
/* 284 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     if (par1EntityLiving instanceof Termite)
/*     */     {
/* 292 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 296 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 301 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 302 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 2.0D, 10.0D));
/* 303 */     Collections.sort(var5, this.TargetSorter);
/* 304 */     Iterator<?> var2 = var5.iterator();
/* 305 */     Entity var3 = null;
/* 306 */     EntityLivingBase var4 = null;
/*     */     
/* 308 */     while (var2.hasNext()) {
/*     */       
/* 310 */       var3 = (Entity)var2.next();
/* 311 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 313 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 315 */         return var4;
/*     */       }
/*     */     } 
/* 318 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 326 */     if (isChild()) {
/* 327 */       enablePersistence();
/* 328 */       return false;
/*     */     } 
/* 330 */     if (isNoDespawnRequired()) return false; 
/* 331 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 336 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Peacock spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 342 */     return new Peacock(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 350 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 359 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 364 */     List var5 = this.worldObj.getEntitiesWithinAABB(Peacock.class, this.boundingBox.expand(16.0D, 10.0D, 16.0D));
/* 365 */     return var5.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Peacock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */