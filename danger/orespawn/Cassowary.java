/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cassowary
/*     */   extends EntityAnimal
/*     */ {
/*  44 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */   
/*     */   public Cassowary(World par1World) {
/*  48 */     super(par1World);
/*     */     
/*  50 */     setSize(0.5F, 1.2F);
/*  51 */     this.moveSpeed = 0.25F;
/*  52 */     this.fireResistance = 100;
/*  53 */     this.experienceValue = 5;
/*  54 */     getNavigator().setAvoidsWater(true);
/*  55 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  56 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  57 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D));
/*  58 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.399999976158142D));
/*  59 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  60 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 12.0F));
/*  61 */     this.tasks.addTask(6, new MyEntityAIWander((EntityCreature)this, 1.0F));
/*  62 */     this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  67 */     super.applyEntityAttributes();
/*  68 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  69 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  70 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  71 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  76 */     super.entityInit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  83 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  84 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 104 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 120 */     return "orespawn:duck_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 128 */     return "orespawn:duck_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 136 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 144 */     return Items.chicken;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 152 */     int var3 = 0;
/* 153 */     var3 = this.rand.nextInt(3);
/* 154 */     var3 += 2;
/* 155 */     for (int var4 = 0; var4 < var3; var4++)
/*     */     {
/* 157 */       dropItem(Items.chicken, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITick() {
/* 168 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 169 */     super.updateAITick();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 174 */     if (!this.worldObj.isDaytime()) return false; 
/* 175 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 183 */     if (isChild()) {
/* 184 */       enablePersistence();
/* 185 */       return false;
/*     */     } 
/* 187 */     if (isNoDespawnRequired()) return false; 
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 193 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cassowary spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 199 */     return new Cassowary(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 207 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 216 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Cassowary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */