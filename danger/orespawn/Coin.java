/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.item.EntityItem;
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
/*     */ public class Coin
/*     */   extends EntityAnimal
/*     */ {
/*  51 */   private float moveSpeed = 0.0F;
/*     */ 
/*     */   
/*     */   public Coin(World par1World) {
/*  55 */     super(par1World);
/*  56 */     setSize(1.5F, 1.5F);
/*     */     
/*  58 */     this.experienceValue = 10;
/*  59 */     this.fireResistance = 100;
/*     */ 
/*     */     
/*  62 */     this.tasks.addTask(0, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  67 */     super.applyEntityAttributes();
/*  68 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  69 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  70 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  71 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  77 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  81 */     if (isNoDespawnRequired()) return false; 
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  91 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  96 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 104 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 121 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 147 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 154 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 161 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 176 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), new ItemStack(index, par1, 0));
/*     */     
/* 178 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 186 */     int i = this.worldObj.rand.nextInt(10);
/*     */     
/* 188 */     Item j = OreSpawnMain.MyEmeraldSword;
/* 189 */     if (i == 0) j = Items.diamond; 
/* 190 */     if (i == 1) j = OreSpawnMain.UraniumNugget; 
/* 191 */     if (i == 2) j = OreSpawnMain.TitaniumNugget; 
/* 192 */     if (i == 3) j = Items.emerald; 
/* 193 */     if (i == 4) j = OreSpawnMain.MyEmeraldAxe; 
/* 194 */     if (i == 5) j = OreSpawnMain.MyEmeraldShovel; 
/* 195 */     if (i == 6) j = OreSpawnMain.MyEmeraldPickaxe; 
/* 196 */     if (i == 7) j = OreSpawnMain.MyEmeraldHoe; 
/* 197 */     if (i == 8) j = OreSpawnMain.CoinEgg;
/*     */     
/* 199 */     dropItemRand(j, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 215 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 224 */     if ((!this.worldObj.isDaytime() ? true : false) == true) return false; 
/* 225 */     if (this.posY < 50.0D) return false; 
/* 226 */     Coin target = null;
/* 227 */     target = (Coin)this.worldObj.findNearestEntityWithinAABB(Coin.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D), (Entity)this);
/* 228 */     if (target != null)
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 238 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Coin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */